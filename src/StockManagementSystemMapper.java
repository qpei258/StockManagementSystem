import java.util.ArrayList;

public interface StockManagementSystemMapper {
	//관리 상품 추가
	public boolean insertProduct(Product p);
	//관리 상품 제거
	public boolean deleteProduct(Product p);
	//관리 상품 수정 : 재고수정(p.stock != null -> 재고 수정), 가격수정(p.price != null -> 가격수정)
	public boolean updateProduct(Product p);
	//전체줄력
	public ArrayList<Product> selectAllProduct();
	//상품 검색
	//검색 수단 : 이름, 번호, 카테고리
	public ArrayList<Product> selectProduct(Product p);
	//주문테이블 검색 (수정사항 있으면 말하기), 테이블에서 검색할때 to_char 사용해서 검색
	public ArrayList<Product> selectbyOrderDate(String date);
	//발주
	public boolean insertTimetable(Product p);
	//로그인
	public boolean selectUser(UserInfo user);
	//회원가입
	public boolean insertUser(UserInfo user);
}
