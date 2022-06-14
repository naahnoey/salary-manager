package salaryManager;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Login extends JFrame{
	
	
	public Login() {
		JPanel p = new JPanel();
		setLocationRelativeTo(p);
		// Label l1 = new Label("���� ���� ���α׷�");
		Label l2 = new Label("���̵�");
		Label l3 = new Label("��й�ȣ");
		// add(l1);
		add(l2);
		add(l3);
		
		
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		add(t1);
		add(t2);
		t2.setEchoChar('*');
		
		
		JButton j1 = new JButton("�α���");
		add(j1);
		
		
		add(p);
		setSize(515, 300);
		setTitle("���� ���� ���α׷�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		
		// l1.setBounds(40, 40, 10000, 40);
		l2.setBounds(101, 72, 40, 40);
		l3.setBounds(95, 122, 50, 40);
		
		t1.setBounds(180, 80, 130, 25);
		t2.setBounds(180, 130, 130, 25);
		
		j1.setBounds(345, 76, 70, 80);
		
		
		
		j1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				String pwd = t2.getText();
				
				salaryDao dao = new salaryDao();
				int result = dao.login(id, pwd); 
				
				if(result == 1) {
					if(id.equals("manager")) {
						JOptionPane.showMessageDialog(null, "�����ڷ� �α��� �߽��ϴ�.");
						ManagerScreen managerScreen = new ManagerScreen();
						dispose();
						
					} else {
						JOptionPane.showMessageDialog(null, "�α��� �߽��ϴ�.");
						EmployeeDetail employeeDetail = new EmployeeDetail();
						dispose();
					} 
						
					} else if (result == 0) {
						JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� Ȯ���ϼ���.");
				}
			
			}
		});
	}
}