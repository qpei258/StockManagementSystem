import java.util.ArrayList;

public interface StockManagerInterface {
	//발주 : 재고수정, 주문테이블 추가 ★★★★ //수현씨
	public boolean order(Product p);

	//관리상품 추가 ★  세진씨
	public boolean addProduct(Product p);
	
	//관리 상품 제거 : 상품 번호 ★ 세진씨
	public boolean deleteProduct(Product p);
	
	//상품 수정 ★★★ 수현씨
	public boolean updateProduct(Product p);
	
	//전체출력 ★ 동우씨
	public ArrayList<Product> printAll();
	
	//상품 검색 ★★★ 동우씨
	public ArrayList<Product> searchProduct(Product p);
	
	//주문 검색 ★ 동우씨
	public ArrayList<Product> searchTimetable(String date);
}
