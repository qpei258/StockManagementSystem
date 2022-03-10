import java.util.ArrayList;

public interface StockManager {
	//발주 : 재고수정, 주문테이블 추가 ★★★★
	public boolean order(Product p);

	//관리상품 추가 ★
	public boolean addProduct(Product p);
	
	//관리 상품 제거 : 상품 번호 ★
	public boolean deleteProduct(Product p);
	
	//상품 수정 ★★★
	public boolean updateProduct(Product p);
	
	//전체출력 ★
	public ArrayList<Product> printAll();
	
	//상품 검색 ★★★
	public ArrayList<Product> searchProduct();
	
	//주문 검색 ★
	public ArrayList<Product> searchTimetable();
}
//9 4 