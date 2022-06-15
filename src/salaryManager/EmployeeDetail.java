package salaryManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.LineBorder;

//���� ȭ��
//�ڽ��� ���� ��ȸ ���� (���� �Ұ�)

public class EmployeeDetail extends JPanel{

	//���� ��ü���� �޾ƿ� ����
	String num = null;	//���
	String name = null;	//�̸�
	String job = null;	//����
	int hour = 0;	//�뵿 �ð�
	String hire = null;	//����Ͻ�
	String account = null;	//���¹�ȣ
	int sal = 0;	//����
	
	SalaryDao dao = new SalaryDao();
	
	public EmployeeDetail() {//�ƹ� ������ ���õ��� �ʾ��� ��
		this(null);
	}
	
	public EmployeeDetail(String num) {
		//�����ͺ��̽����� ��� ��ġ�ϴ� ���� ���� �ҷ��� ������ ��������� ����
		if (num != null) {
			ResultSet rs = dao.employeeInquiry(num);
			try {
				rs.next();
				this.num = rs.getString("enum");
				name = rs.getString("ename");
				job = rs.getString("job");
				hour = rs.getInt("workingHours");
				hire = rs.getString("hire");
				account = rs.getString("account");
				sal = rs.getInt("sal");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		drawPanel();
	}
	
	public void drawPanel() {
		setSize(680, 550);
		setLayout(null);	//���̾ƿ� ����
		
		//���� �̹���
		EmployeeImage employeeImage = new EmployeeImage("src//image//img1.png");
		employeeImage.setBounds(30, 30, 150, 200);
		
		//���� ������ - �̸�, ����, ��ٿ���, �뵿�ð�
		InfoEmployee infoEmployee = new InfoEmployee();
		infoEmployee.setBounds(200, 30, 450, 240);
		
		//���� ������ - ����Ͻ�, ���¹�ȣ
		InfoEmployee2 infoEmployee2 = new InfoEmployee2();
		infoEmployee2.setBounds(30, 270, 600, 100);
		
		//����
		JLabel salL = new JLabel("���� ����: " + sal + "��");
		salL.setFont(new Font("���", Font.BOLD, 16));
		salL.setBounds(470, 380, 200, 50);
		
		//�α׾ƿ� ��ư
		JButton logoutB = new JButton("�α׾ƿ�");
		logoutB.setBounds(290, 450, 100, 40);
		
		logoutB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	((Window) getRootPane().getParent()).dispose();
            	new Login();
            }
        });
		
		
		add(employeeImage);
		add(infoEmployee);
		add(infoEmployee2);
		add(salL);
		add(logoutB);
		
		setVisible(true);
	}
	
	//���� ������ - �̸�, ����, ��� ����, �뵿 �ð�
	class InfoEmployee extends JPanel {
		
		public InfoEmployee() {
			Font font = new Font("���", Font.BOLD, 16);
			LineBorder lb = new LineBorder(Color.BLACK, 1, true);
			
			setLayout(null);
			
			//���, �̸�, ����, �뵿 �ð�
			JPanel ep = new JPanel();
			ep.setLayout(new GridLayout(0, 1, 0, -1));
			JLabel numL = new JLabel("��� ", SwingConstants.RIGHT);
			JLabel nameL = new JLabel("�̸� ", SwingConstants.RIGHT);
			JLabel jobL = new JLabel("���� ", SwingConstants.RIGHT);
			JLabel hourL = new JLabel("�뵿 �ð� ", SwingConstants.RIGHT);
			
			//��Ʈ ����
			numL.setFont(font);
			nameL.setFont(font);
			jobL.setFont(font);
			hourL.setFont(font);
			
			//�׵θ� ����
			numL.setBorder(lb);
			nameL.setBorder(lb);	
			jobL.setBorder(lb);
			hourL.setBorder(lb);
			ep.add(numL);	ep.add(nameL);	ep.add(jobL);	ep.add(hourL);
			ep.setBounds(0, 0, 80, 200);
			
			//�� ��Ͽ� ���� ���� �� ����
			JPanel infoP = new JPanel();
			infoP.setLayout(new GridLayout(0, 1, 0, -1));
			JLabel infoNumL = new JLabel(" " + num);
			JLabel infoNameL = new JLabel(" " + name);
			JLabel infoJobL = new JLabel(" " + job);
			JLabel infoHourL = new JLabel(" " + hour);
			infoNumL.setFont(font);
			infoNameL.setFont(font);
			infoJobL.setFont(font);
			infoHourL.setFont(font);
			
			infoNumL.setBorder(lb);
			infoNameL.setBorder(lb);	
			infoJobL.setBorder(lb);
			infoHourL.setBorder(lb);
			
			infoP.add(infoNumL);	infoP.add(infoNameL);	infoP.add(infoJobL);	infoP.add(infoHourL);
			infoP.setBounds(80, 0, 350, 200);
			
			add(ep);
			add(infoP);
		}
		
	}	//end infoEmployee
	
	//���� ������ - ����Ͻ�, ���¹�ȣ
	class InfoEmployee2 extends JPanel {
		
		public InfoEmployee2() {
			Font font = new Font("���", Font.BOLD, 16);
			LineBorder lb = new LineBorder(Color.BLACK, 1, true);
			
			setLayout(null);
			
			//����, �ʰ��ٹ�
			JPanel ep = new JPanel();
			ep.setLayout(new GridLayout(0, 1, 0, -1));
			JLabel hireL = new JLabel("����Ͻ� ", SwingConstants.RIGHT);
			JLabel accountL = new JLabel("���¹�ȣ ", SwingConstants.RIGHT);
			
			//��Ʈ ����
			hireL.setFont(font);	
			accountL.setFont(font);
			
			//�׵θ� ����
			hireL.setBorder(lb);	
			accountL.setBorder(lb);
			ep.add(hireL);	ep.add(accountL);
			ep.setBounds(0, 0, 80, 100);
			
			//�� ��Ͽ� ���� ���� �� ����
			JPanel infoP = new JPanel();
			infoP.setLayout(new GridLayout(0, 1, 0, -1));
			JLabel infoHireL = new JLabel(" " + hire);
			JLabel infoAccountL = new JLabel(" " + account);
			infoHireL.setFont(font);
			infoAccountL.setFont(font);
			
			infoHireL.setBorder(lb);	
			infoAccountL.setBorder(lb);
			
			infoP.add(infoHireL);	infoP.add(infoAccountL);
			infoP.setBounds(80, 0, 520, 100);
			
			add(ep);
			add(infoP);
		}
		
	}
	
	//���� �̹���
	class EmployeeImage extends JPanel {	//BLOB���� ����
		private ImageIcon ii;
		private Image image;
		
		public EmployeeImage() {
			ii = null;
		}
		
		public EmployeeImage(String url) {
			ii = new ImageIcon(url);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			//���� �̹����� �������� ������ '�̹��� ����' ���
			if (ii == null)	{
				g.drawString("�̹��� ����", 45, 105);
				return;
			}
			
			//���� �̹����� �����ϸ� Image ��ü ����
			image = ii.getImage();
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}
	
}
