
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

	//��� ���� ��ǰ ����
	//��ǰ �̸�
	public String pname;
	//��ǰ ����
	public int price;
	//��ǰ ��ȣ
	public int pnumber;
	//��ǰ �з�
	public String category;
	//��ǰ ���
	public int stock;
	//���� ���̵�
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
