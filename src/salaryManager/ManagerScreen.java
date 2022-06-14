package salaryManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;

//���� ȭ�� ����

public class ManagerScreen extends JFrame {
	//JList�� ���� ��� ����
	//��� �� �ϳ� ���ý� �ش� ���� ���� ��� - EmployeeDetail Ŭ���� �̿�
	
	JFrame frame = this;
	
	public ManagerScreen() {
		setTitle("���� ���� ���α׷� (����)");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(850, 550);
		setLocationRelativeTo(this);
		
		setLayout(new BorderLayout());	//���̾ƿ� ����
		
		add(new ListPanel(), BorderLayout.WEST);
		add(new EmployeeDetail(), BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	//���� ����Ʈ
	//���� �߰�, ����, ���� ��ư
	private class ListPanel extends JPanel {
		//���� ��� ���
		//�����ͺ��̽����� �̸��� id ������ JList�� ������ ����
		
		//���� �̸�, id ���� ����Ʈ
		Vector<String> nameV = new Vector<String>();
		JList<String> nameList = new JList<String>(nameV);
		
		public ListPanel() {
			setLayout(new BorderLayout(0, 10));
			JLabel label = new JLabel("���� ���");
			nameList.setVisibleRowCount(10);	//��Ͽ��� �������� ���� ��
			nameList.setFixedCellWidth(100);
			nameList.setFixedCellHeight(30);
			
			//���� �߰�â
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
			add(new JScrollPane(nameList), BorderLayout.CENTER);
			add(buttonP, BorderLayout.SOUTH);
		}
	}
	
}
