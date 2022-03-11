import java.util.ArrayList;
import java.util.Scanner;

public class ManagementUI {

	private UserInfo user_logined;
	private Scanner sc = new Scanner(System.in);
	private SigninManager sim = new SigninManager();
	private StockManager stm = new StockManager();
	
	public ManagementUI() {
		menu();
	}
	
	public void menu() {
		int key;
		boolean triger = true;
		while(triger) {
			System.out.println("---메인 화면---");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.print("메뉴 선택 : ");
			try {
				key = sc.nextInt();
			}catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			switch (key) {
			case 1:
				if(login())
					triger = false;
				break;
			case 2:
				signup();
				break;
			}
		}
		
		triger = true;
		while(triger) {
			System.out.println("---매니저 화면---");
			System.out.println("1. 발주");
			System.out.println("2. 상품 관리");
			System.out.println("3. 주문 검색");
			System.out.println("4. 종료");
			System.out.print("메뉴 선택 : ");
			try {
				key = sc.nextInt();
			}catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			switch (key) {
			case 1:
				order();
				break;
			case 2:
				System.out.println("---상품 관리---");
				System.out.println("1. 관리 상품 추가");
				System.out.println("2. 관리 상품 수정");
				System.out.println("3. 관리 상품 제거");
				System.out.println("4. 전체 출력");
				System.out.println("5. 이전 메뉴");
				System.out.print("메뉴 선택 : ");
				try {
					key = sc.nextInt();
				}catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					continue;
				}
				switch (key) {
				case 1:
					addProduct();
					break;
				case 2:
					modifyProduct();
					break;	
				case 3:
					removeProduct();
					break;				
				case 4:
					printAll();
					break;	
				case 5:
					continue;
				default:
				}
				break;
			case 3:
				ordertable();
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("다시 입력해주세요");
			}
		}
		
	}
	
	//로그인
	public boolean login() {
		System.out.println("---로그인---");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String password = sc.next();
		UserInfo user = new UserInfo(id, password);
		if(sim.signin(user)) {
			user_logined = user;
			System.out.println("로그인에 성공했습니다.");
			return true;
		}else
			System.out.println("로그인에 실패했습니다.");
			return false;
	}
	
	//회원가입
	public boolean signup() {
		System.out.println("---회원가입---");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String password = sc.next();
		UserInfo user = new UserInfo(id, password);
		if(sim.signup(user)) {
			System.out.println("회원가입에 성공했습니다.");
			return true;
		}else
			System.out.println("회원가입에 실패했습니다.");
			return false;
	}
	
	
	//발주
	public void order() {
		System.out.println("---발주---");
		System.out.print("상품 이름 : ");
		String pname = sc.next();
		System.out.print("주문 수량 : ");
		int count;
		try {
			count = sc.nextInt();
		}catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		Product p = new Product();
		p.setPname(pname);
		p.setStock(count);
		boolean result = stm.order(p);
		if(result)
			System.out.println("상품을 발주하셨습니다.");
		else
			System.out.println("상품 발주에 실패하셨습니다.");
	}
	
	
	//주문 검색(날짜 별 발주 목록)
	public void ordertable( ) {
		System.out.println("---발주 목록---");
		System.out.print("날짜 :");
		String date = sc.next();
		ArrayList<Product> list = stm.searchTimetable(date);
		for(Product p : list) {
			System.out.println("상품명 :" + p.getPname() + "상품번호 : " + p.getPnumber() + "발주 수량 : " + p.getStock());
		}
	}
	
	//관리 상품 추가
	public void addProduct() {
		Product p;
		try {
			System.out.println("---관리 상품 추가---");
			System.out.print("상품명 : ");
			String pname = sc.next();
			System.out.print("상품번호 : ");
			int pnumber = sc.nextInt();
			System.out.print("상품가격 : ");
			int price = sc.nextInt();
			System.out.print("카테고리");
			System.out.println("1.음료");
			System.out.println("2.과자");
			System.out.println("3.생필품");
			System.out.println("4.소모품");
			System.out.print("카테고리를 선택해주세요 : ");
			int key = sc.nextInt();
			String category;
			switch (key) {
			case 1:
				category = "음료";
				break;
			case 2:
				category = "과자";
				break;
			case 3:
				category = "생필품";
				break;
			case 4:
				category = "소모품";
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				return;
			}
			p = new Product(pname, price, pnumber, category, 0, user_logined.getId());
		}catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		boolean result = stm.addProduct(p);
		if(result)
			System.out.println("관리 상품 추가에 성공하였습니다.");
		else
			System.out.println("관리 상품 추가에 실패하였습니다.");
	}
	
	//관리 상품 수정
	public void modifyProduct() {
		Product p = new Product();
		String pname, category;
		int stock, price;
		try {
			System.out.println("---관리 상품 수정---");
			System.out.print("수정할 상품의 번호 : ");
			int num = sc.nextInt();
			p.setPnumber(num);
			ArrayList<Product> product = stm.searchProduct(p);
			p = product.get(0);
			if(p == null) {
				System.out.println("존재하지 않는 상품 번호입니다.");
				return;
			}
			System.out.println("---수정 항목---");
			System.out.println("1.상품명");
			System.out.println("2.재고");
			System.out.println("3.가격");
			System.out.println("4.카테고리");
			System.out.println("5.이전 메뉴");
			int key = sc.nextInt();
			switch (key) {
			case 1:
				System.out.print("수정할 상품명 : ");
				pname = sc.next();
				p.setPname(pname);
				break;
			case 2:
				System.out.println("수정할 재고 : ");
				stock = sc.nextInt();
				p.setStock(stock);
				break;
			case 3:
				System.out.print("수정할 상품가격 : ");
				price = sc.nextInt();
				p.setPrice(price);
				break;
			case 4:
				System.out.print("수정할 카테고리");
				System.out.println("1.음료");
				System.out.println("2.과자");
				System.out.println("3.생필품");
				System.out.println("4.소모품");
				System.out.println("5.이전 메뉴");
				System.out.print("카테고리를 선택해주세요 : ");
				key = sc.nextInt();
				switch (key) {
				case 1:
					category = "음료";
					break;
				case 2:
					category = "과자";
					break;
				case 3:
					category = "생필품";
					break;
				case 4:
					category = "소모품";
					break;
				default:
					System.out.println("이전 메뉴로 향합니다.");
					return;
				}
				p.setCategory(category);
				break;
			default:
				System.out.println("이전 메뉴로 향합니다.");
				return;
			}
			
		}catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		boolean result = stm.updateProduct(p);
		if(result)
			System.out.println("관리 상품 수정에 성공하였습니다.");
		else
			System.out.println("관리 상품 수정에 실패하였습니다.");
	}
	
	//관리 상품 제거
	public void removeProduct() {
		Product p = new Product();
		try {
			System.out.println("---관리 상품 제거---");
			System.out.print("제거할 상품의 번호 : ");
			int num = sc.nextInt();
			p.setPnumber(num);
			boolean result = stm.deleteProduct(p);
			if(result) {
				System.out.println("상품 제거에 성공하였습니다.");
			}else {
				System.out.println("상품 제거에 실패하였습니다.");
			}
		}catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			return;
		}
	}
	
	
	//전체 출력
	public void printAll() {
		ArrayList<Product> list = stm.printAll();
		for(Product p : list) {
			System.out.println(p);
		}
	}
	public static void main(String[] args) {
		ManagementUI UI = new ManagementUI();
	}

}
