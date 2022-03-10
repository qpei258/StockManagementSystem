import java.util.ArrayList;

public interface StockManagementSystemMapper {
	//���� ��ǰ �߰�
	public boolean insertProduct(Product p);
	//���� ��ǰ ����
	public boolean deleteProduct(Product p);
	//���� ��ǰ ���� : ������(p.stock != null -> ��� ����), ���ݼ���(p.price != null -> ���ݼ���)
	public boolean updateProduct(Product p);
	//��ü�ٷ�
	public ArrayList<Product> selectAllProduct();
	//��ǰ �˻�
	//�˻� ���� : �̸�, ��ȣ, ī�װ�
	public ArrayList<Product> selectProduct(Product p);
	//�ֹ����̺� �˻� (�������� ������ ���ϱ�), ���̺��� �˻��Ҷ� to_char ����ؼ� �˻�
	public ArrayList<Product> selectbyOrderDate(String date);
	//����
	public boolean insertTimetable(Product p);
	//�α���
	public boolean selectUser(UserInfo user);
	//ȸ������
	public boolean insertUser(UserInfo user);
}
