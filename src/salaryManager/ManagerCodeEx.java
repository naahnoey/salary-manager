package salaryManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerCodeEx {
//	���� �α��� �� ��ü �����͸� �̴°� �ʱ⿡ ��ȹ�ߴ� �� ó�� ���� ���� ������ �����°� �����ϱⰡ ���� ������ �մϴ� �Ф�
//	���� ��Ĵ�� �� ������� �ѹ��� ����ϴ°� �ּ��ϵ� �ؿ� �Ф�
	public void printManagerScreen() {
		ResultSet rs = null;

		salaryDao sd = new salaryDao();

		rs = sd.managerInquiry();

		try {
			while (rs.next()) {
//				��� ���: ���, �̸�, ����, ����Ͻ�, �����Ͻ�, ���¹�ȣ, �ñ�, �ٹ��ð�, ����
				System.out.printf(
						"���: %s \n�̸�: %s \n����: %s \n����Ͻ�: %s \n�����Ͻ�: %s \n���¹�ȣ: %s \n�ñ�: %d \n���� �ٹ��ð�: %d \n����: %d",
						rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
				System.out.println("\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
