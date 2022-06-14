package salaryManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// ��� ��ũ: https://equatorial-spring-619.notion.site/Dao-d19cd0ae6bbc4c28a0a259445c4de298
// �ֿ� ���: ��ȸ ���, ���� ���

public class SalaryDao {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/salarymanagement";
	String userid = "root";
	String password = "1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int irs;

//	1. ��ȸ���
//	1-1 ���� ��ȸ
	public ResultSet managerInquiry() {
		try {
			calculSal();

			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
//			��� ���: ���, �̸�, ����, ����Ͻ�, �����Ͻ�, ���¹�ȣ, �ñ�, �ٹ��ð�, ����
			String query = "SELECT e.enum, e.ename, e.job, e.hire, e.quit, e.account, l.hourlyWage, l.workingHours, l.sal FROM employee e LEFT JOIN labor l ON e.enum = l.enum";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

//	1-2 ���� ��ȸ
	public ResultSet employeeInquiry(String employee_number) {
		try {
			calculSal();

			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
//			String query = "SELECT * FROM labor WHERE enum = ?";
			String query = "SELECT e.enum, e.ename, e.job, e.hire, e.quit, e.account, l.hourlyWage, l.workingHours, l.sal FROM employee e LEFT JOIN labor l ON e.enum = l.enum WHERE e.enum = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, employee_number);
			rs = pstmt.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

//	2. ���� ���
//	

//	2-1 �ʱ� ���� �Է�
//	�Ű�����: ���, �̸�, ����, ����Ͻ�, ���¹�ȣ, �Ѵ޵��� ���ϴ� �ð�
	public int insertEmployee(String employee_number, String ename, String job, String hire, String account,
			int workingHours) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
//			employee ���̺� ����
			String query1 = "INSERT INTO employee (enum, ename, job, hire, account) VALUES (?, ?, ?, ?, ?)";
			String query2 = "INSERT INTO labor (enum, workingHours) VALUES (?, ?)";

//			(INSERT, DELECT ��)�� ����: .execute() Ȥ�� .executeUpdate() ���
//			����� int�� �ƴϸ� boolean�� �����ϹǷ� rs�� ��Ȳ�� ���� �ٲ۴�. 

			pstmt = conn.prepareStatement(query1);
			pstmt.setString(1, employee_number);
			pstmt.setString(2, ename);
			pstmt.setString(3, job);
			pstmt.setString(4, hire);
			pstmt.setString(5, account);
			irs = pstmt.executeUpdate();

			pstmt = conn.prepareStatement(query2);
			pstmt.setString(1, employee_number);
			pstmt.setInt(2, workingHours);
			irs = pstmt.executeUpdate();

			return irs;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0;

	}

//	2-2 ���� ����
//	2-2-1 ������ ����
	public void quitEmployee(String employee_number, String quitDate) {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
			String query = "UPDATE employee SET quit = ? WHERE enum = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, quitDate);
			pstmt.setString(2, employee_number);
			irs = pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	2-2-2 �������� ����
	public void editAccount(String employee_number, String account) {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
			String query = "UPDATE employee SET account = ? WHERE enum = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, account);
			pstmt.setString(2, employee_number);
			irs = pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	2-2-3 ���� ���� ����
	public void delEmployee(String employee_number) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
			String query1 = "DELETE FROM labor WHERE enum = ?";
			pstmt = conn.prepareStatement(query1);
			pstmt.setString(1, employee_number);
			irs = pstmt.executeUpdate();

			String query2 = "DELETE FROM employee WHERE enum = ?";
			pstmt = conn.prepareStatement(query2);
			pstmt.setString(1, employee_number);
			irs = pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	3. ���� ��� ����
	public void calculSal() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
			String calculQuery = "UPDATE labor SET sal = hourlyWage * workingHours";
			pstmt = conn.prepareStatement(calculQuery);
			irs = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	4. �α��� �޼ҵ�
	public int login(String id, String pwd) {
		List<String> list = new ArrayList<>(Arrays.asList("1234", "5678", "4321", "8765"));

		if (list.contains(pwd)) {
			return 1;
		} else {
			return 0;
		}
	}

}
