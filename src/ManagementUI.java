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
			System.out.println("---���� ȭ��---");
			System.out.println("1. �α���");
			System.out.println("2. ȸ������");
			System.out.print("�޴� ���� : ");
			try {
				key = sc.nextInt();
			}catch (Exception e) {
				System.out.println("�߸��� �Է��Դϴ�.");
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
			System.out.println("---�Ŵ��� ȭ��---");
			System.out.println("1. ����");
			System.out.println("2. ��ǰ ����");
			System.out.println("3. �ֹ� �˻�");
			System.out.println("4. ����");
			System.out.print("�޴� ���� : ");
			try {
				key = sc.nextInt();
			}catch (Exception e) {
				System.out.println("�߸��� �Է��Դϴ�.");
				continue;
			}
			switch (key) {
			case 1:
				order();
				break;
			case 2:
				System.out.println("---��ǰ ����---");
				System.out.println("1. ���� ��ǰ �߰�");
				System.out.println("2. ���� ��ǰ ����");
				System.out.println("3. ���� ��ǰ ����");
				System.out.println("4. ��ü ���");
				System.out.println("5. ���� �޴�");
				System.out.print("�޴� ���� : ");
				try {
					key = sc.nextInt();
				}catch (Exception e) {
					System.out.println("�߸��� �Է��Դϴ�.");
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
				System.out.println("�ٽ� �Է����ּ���");
			}
		}
		
	}
	
	//�α���
	public boolean login() {
		System.out.println("---�α���---");
		System.out.print("���̵� : ");
		String id = sc.next();
		System.out.print("��й�ȣ : ");
		String password = sc.next();
		UserInfo user = new UserInfo(id, password);
		if(sim.signin(user)) {
			user_logined = user;
			System.out.println("�α��ο� �����߽��ϴ�.");
			return true;
		}else
			System.out.println("�α��ο� �����߽��ϴ�.");
			return false;
	}
	
	//ȸ������
	public boolean signup() {
		System.out.println("---ȸ������---");
		System.out.print("���̵� : ");
		String id = sc.next();
		System.out.print("��й�ȣ : ");
		String password = sc.next();
		UserInfo user = new UserInfo(id, password);
		if(sim.signup(user)) {
			System.out.println("ȸ�����Կ� �����߽��ϴ�.");
			return true;
		}else
			System.out.println("ȸ�����Կ� �����߽��ϴ�.");
			return false;
	}
	
	
	//����
	public void order() {
		System.out.println("---����---");
		System.out.print("��ǰ �̸� : ");
		String pname = sc.next();
		System.out.print("�ֹ� ���� : ");
		int count;
		try {
			count = sc.nextInt();
		}catch (Exception e) {
			System.out.println("�߸��� �Է��Դϴ�.");
			return;
		}
		Product p = new Product();
		p.setPname(pname);
		p.setStock(count);
		boolean result = stm.order(p);
		if(result)
			System.out.println("��ǰ�� �����ϼ̽��ϴ�.");
		else
			System.out.println("��ǰ ���ֿ� �����ϼ̽��ϴ�.");
	}
	
	
	//�ֹ� �˻�(��¥ �� ���� ���)
	public void ordertable( ) {
		System.out.println("---���� ���---");
		System.out.print("��¥ :");
		String date = sc.next();
		ArrayList<Product> list = stm.searchTimetable(date);
		for(Product p : list) {
			System.out.println("��ǰ�� :" + p.getPname() + "��ǰ��ȣ : " + p.getPnumber() + "���� ���� : " + p.getStock());
		}
	}
	
	//���� ��ǰ �߰�
	public void addProduct() {
		Product p;
		try {
			System.out.println("---���� ��ǰ �߰�---");
			System.out.print("��ǰ�� : ");
			String pname = sc.next();
			System.out.print("��ǰ��ȣ : ");
			int pnumber = sc.nextInt();
			System.out.print("��ǰ���� : ");
			int price = sc.nextInt();
			System.out.print("ī�װ�");
			System.out.println("1.����");
			System.out.println("2.����");
			System.out.println("3.����ǰ");
			System.out.println("4.�Ҹ�ǰ");
			System.out.print("ī�װ��� �������ּ��� : ");
			int key = sc.nextInt();
			String category;
			switch (key) {
			case 1:
				category = "����";
				break;
			case 2:
				category = "����";
				break;
			case 3:
				category = "����ǰ";
				break;
			case 4:
				category = "�Ҹ�ǰ";
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				return;
			}
			p = new Product(pname, price, pnumber, category, 0, user_logined.getId());
		}catch (Exception e) {
			System.out.println("�߸��� �Է��Դϴ�.");
			return;
		}
		boolean result = stm.addProduct(p);
		if(result)
			System.out.println("���� ��ǰ �߰��� �����Ͽ����ϴ�.");
		else
			System.out.println("���� ��ǰ �߰��� �����Ͽ����ϴ�.");
	}
	
	//���� ��ǰ ����
	public void modifyProduct() {
		Product p = new Product();
		String pname, category;
		int stock, price;
		try {
			System.out.println("---���� ��ǰ ����---");
			System.out.print("������ ��ǰ�� ��ȣ : ");
			int num = sc.nextInt();
			p.setPnumber(num);
			ArrayList<Product> product = stm.searchProduct(p);
			p = product.get(0);
			if(p == null) {
				System.out.println("�������� �ʴ� ��ǰ ��ȣ�Դϴ�.");
				return;
			}
			System.out.println("---���� �׸�---");
			System.out.println("1.��ǰ��");
			System.out.println("2.���");
			System.out.println("3.����");
			System.out.println("4.ī�װ�");
			System.out.println("5.���� �޴�");
			int key = sc.nextInt();
			switch (key) {
			case 1:
				System.out.print("������ ��ǰ�� : ");
				pname = sc.next();
				p.setPname(pname);
				break;
			case 2:
				System.out.println("������ ��� : ");
				stock = sc.nextInt();
				p.setStock(stock);
				break;
			case 3:
				System.out.print("������ ��ǰ���� : ");
				price = sc.nextInt();
				p.setPrice(price);
				break;
			case 4:
				System.out.print("������ ī�װ�");
				System.out.println("1.����");
				System.out.println("2.����");
				System.out.println("3.����ǰ");
				System.out.println("4.�Ҹ�ǰ");
				System.out.println("5.���� �޴�");
				System.out.print("ī�װ��� �������ּ��� : ");
				key = sc.nextInt();
				switch (key) {
				case 1:
					category = "����";
					break;
				case 2:
					category = "����";
					break;
				case 3:
					category = "����ǰ";
					break;
				case 4:
					category = "�Ҹ�ǰ";
					break;
				default:
					System.out.println("���� �޴��� ���մϴ�.");
					return;
				}
				p.setCategory(category);
				break;
			default:
				System.out.println("���� �޴��� ���մϴ�.");
				return;
			}
			
		}catch (Exception e) {
			System.out.println("�߸��� �Է��Դϴ�.");
			return;
		}
		boolean result = stm.updateProduct(p);
		if(result)
			System.out.println("���� ��ǰ ������ �����Ͽ����ϴ�.");
		else
			System.out.println("���� ��ǰ ������ �����Ͽ����ϴ�.");
	}
	
	//���� ��ǰ ����
	public void removeProduct() {
		Product p = new Product();
		try {
			System.out.println("---���� ��ǰ ����---");
			System.out.print("������ ��ǰ�� ��ȣ : ");
			int num = sc.nextInt();
			p.setPnumber(num);
			boolean result = stm.deleteProduct(p);
			if(result) {
				System.out.println("��ǰ ���ſ� �����Ͽ����ϴ�.");
			}else {
				System.out.println("��ǰ ���ſ� �����Ͽ����ϴ�.");
			}
		}catch (Exception e) {
			System.out.println("�߸��� �Է��Դϴ�.");
			return;
		}
	}
	
	
	//��ü ���
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
