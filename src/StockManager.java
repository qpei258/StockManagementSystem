import java.util.ArrayList;

public interface StockManager {
	//���� : ������, �ֹ����̺� �߰� �ڡڡڡ�
	public boolean order(Product p);

	//������ǰ �߰� ��
	public boolean addProduct(Product p);
	
	//���� ��ǰ ���� : ��ǰ ��ȣ ��
	public boolean deleteProduct(Product p);
	
	//��ǰ ���� �ڡڡ�
	public boolean updateProduct(Product p);
	
	//��ü��� ��
	public ArrayList<Product> printAll();
	
	//��ǰ �˻� �ڡڡ�
	public ArrayList<Product> searchProduct();
	
	//�ֹ� �˻� ��
	public ArrayList<Product> searchTimetable();
}
//9 4 