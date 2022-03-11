import java.util.ArrayList;

public interface StockManagerInterface {
	//���� : ������, �ֹ����̺� �߰� �ڡڡڡ� //������
	public boolean order(Product p);

	//������ǰ �߰� ��  ������
	public boolean addProduct(Product p);
	
	//���� ��ǰ ���� : ��ǰ ��ȣ �� ������
	public boolean deleteProduct(Product p);
	
	//��ǰ ���� �ڡڡ� ������
	public boolean updateProduct(Product p);
	
	//��ü��� �� ���쾾
	public ArrayList<Product> printAll();
	
	//��ǰ �˻� �ڡڡ� ���쾾
	public ArrayList<Product> searchProduct(Product p);
	
	//�ֹ� �˻� �� ���쾾
	public ArrayList<Product> searchTimetable(String date);
}
