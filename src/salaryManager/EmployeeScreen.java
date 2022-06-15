package salaryManager;

import javax.swing.JFrame;

public class EmployeeScreen extends JFrame {

	public EmployeeScreen(String id) {
		super("월급 관리 프로그램(직원)");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(680, 550);
		setLocationRelativeTo(this);
		
		EmployeeDetail ed = new EmployeeDetail(id);
		add(ed);
		
		setVisible(true);
	}
	
}
