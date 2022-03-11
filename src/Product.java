
public class Product {
	
	public Product() {
	
	}
	
	public Product(String pname, int price, int pnumber, String category, int stock, String id) {
		super();
		this.pname = pname;
		this.price = price;
		this.pnumber = pnumber;
		this.category = category;
		this.stock = stock;
		this.id = id;
	}

	//재고 관리 상품 정보
	//상품 이름
	public String pname;
	//상품 가격
	public int price;
	//상품 번호
	public int pnumber;
	//상품 분류
	public String category;
	//상품 재고
	public int stock;
	//유저 아이디
	public String id;
	
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPnumber() {
		return pnumber;
	}
	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Product [pname=" + pname + ", price=" + price + ", pnumber=" + pnumber + ", category=" + category
				+ ", stock=" + stock + "]";
	}
}
