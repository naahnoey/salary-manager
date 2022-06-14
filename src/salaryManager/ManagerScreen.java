package salaryManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


//���� ȭ�� ����

public class ManagerScreen extends JFrame {
	//JList�� ���� ��� ����
	//��� �� �ϳ� ���ý� �ش� ���� ���� ��� - EmployeeDetail Ŭ���� �̿�
	
	JFrame frame = this;
	SalaryDao dao = new SalaryDao();
	Vector<String> numV = new Vector<String>();	//���� ��� ���� ����
	JList<String> numList = new JList<String>(numV);
	
	Container c = getContentPane();	//ManagerScreen â
	EmployeeDetail ed = new EmployeeDetail();
	
	public ManagerScreen() {
		setTitle("���� ���� ���α׷� (����)");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(850, 550);
		setLocationRelativeTo(this);
		
		c.setLayout(new BorderLayout());	//���̾ƿ� ����
		
		c.add(new ListPanel(), BorderLayout.WEST);
		c.add(ed, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	//���� ����Ʈ
	//���� �߰�, ����, ���� ��ư
	private class ListPanel extends JPanel {
		//���� ��� ���
		//�����ͺ��̽����� ��� ������ JList�� ������ ����
		
		public ListPanel() {
			setLayout(new BorderLayout(0, 10));
			
			//�����ͺ��̽����� ���� ��� �ҷ��� ��� ���Ϳ� ����
			try {
				ResultSet rs = dao.managerInquiry();
				while(rs.next()) {
					numV.add(rs.getString("enum"));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			numList.setListData(numV);	//���� ������� ����� ����Ʈ ����
			
			JLabel label = new JLabel("���� ���");
			numList.setVisibleRowCount(10);	//��Ͽ��� �������� ���� ��
			numList.setFixedCellWidth(100);
			numList.setFixedCellHeight(30);
			
			//����Ʈ���� ���� ���ý� �ش� ���� ���� ���
			numList.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					c.remove(ed);	//���� ���� �� ���� ���ֱ�
					
					String num = numList.getSelectedValue();	//Ŭ���� ���
					ed = new EmployeeDetail(num);	//�ش� ������ �� ����
					
					c.add(ed, BorderLayout.CENTER);
					c.repaint();
				}
			});
			
			//���� �߰� ���̾�α�
			AddEmployee addEmployee = new AddEmployee(frame, "���� �߰�");
			
			//��ư �г�
			JPanel buttonP = new JPanel();
			//�߰� ��ư
			JButton addB = new JButton("�߰�");
			addB.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// ��ư Ŭ�� �� �߰� ���̾�α� �߰� ��
					addEmployee.setVisible(true);
				}
			});
			
			//���� ��ư
			JButton delB = new JButton("����");
			//���� ��ư
			JButton corB = new JButton("����");
			buttonP.add(addB);
			buttonP.add(delB);
			buttonP.add(corB);
			
			add(label, BorderLayout.NORTH);
			add(new JScrollPane(numList), BorderLayout.CENTER);
			add(buttonP, BorderLayout.SOUTH);
		}
	}
	
	//Dao���� ���� ��� �޾ƿ� numList ������Ʈ
	public void updateNumList(String num) {
		numV.add(num);
		numList.setListData(numV);
	}
	
}
