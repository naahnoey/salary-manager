package salaryManager;

import javax.swing.JFrame;

public class EmployeeScreen extends JFrame {

	public EmployeeScreen(String id) {
		super("���� ���� ���α׷�(����)");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(680, 550);
		setLocationRelativeTo(this);
		
		EmployeeDetail ed = new EmployeeDetail(id);
		add(ed);
		
		setVisible(true);
	}
	
}
