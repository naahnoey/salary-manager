package salaryManager;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

//���� ȭ��
//�ڽ��� ���� ��ȸ ���� (���� �Ұ�)

public class EmployeeDetail extends JFrame{

	public EmployeeDetail() {
		super("���� ���� ���α׷� (����)");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(680, 550);
		setLocationRelativeTo(this);
		setLayout(null);	//���̾ƿ� ����
		
		//���� �̹���
		EmployeeImage employeeImage = new EmployeeImage("src//image//img1.png");
		employeeImage.setBounds(30, 30, 150, 200);
		
		//���� ������ - �̸�, ����, ��ٿ���, �뵿�ð�
		InfoEmployee infoEmployee = new InfoEmployee();
		infoEmployee.setBounds(200, 30, 450, 240);
		
		//���� ������ - ����, �ʰ��ٹ� ���
		InfoEmployee2 infoEmployee2 = new InfoEmployee2();
		infoEmployee2.setBounds(30, 270, 600, 100);
		
		//����
		JLabel salL = new JLabel("���� ����: 000000��");
		salL.setBounds(500, 380, 200, 50);
		
		//�α׾ƿ� ��ư
		JButton logoutB = new JButton("�α׾ƿ�");
		logoutB.setBounds(290, 450, 100, 40);
		
		
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
			String name, age, day, hour;	//���� ��ü���� �޾ƿ� ����
			Font font = new Font("���", Font.BOLD, 16);
			LineBorder lb = new LineBorder(Color.BLACK, 1, true);
			
			setLayout(null);
			
			//�̸�, ����, ��� ����, �뵿 �ð�
			JPanel ep = new JPanel();
			ep.setLayout(new GridLayout(0, 1, 0, -1));
			JLabel nameL = new JLabel("�̸� ", SwingConstants.RIGHT);
			JLabel ageL = new JLabel("���� ", SwingConstants.RIGHT);
			JLabel dayL = new JLabel("��� ���� ", SwingConstants.RIGHT);
			JLabel hourL = new JLabel("�뵿 �ð� ", SwingConstants.RIGHT);
			
			//��Ʈ ����
			nameL.setFont(font);	
			ageL.setFont(font);
			dayL.setFont(font);
			hourL.setFont(font);
			
			//�׵θ� ����
			nameL.setBorder(lb);	
			ageL.setBorder(lb);
			dayL.setBorder(lb);
			hourL.setBorder(lb);
			ep.add(nameL);	ep.add(ageL);	ep.add(dayL);	ep.add(hourL);
			ep.setBounds(0, 0, 80, 200);
			
			//�� ��Ͽ� ���� ���� �� ����
			JPanel infoP = new JPanel();
			infoP.setLayout(new GridLayout(0, 1, 0, -1));
			JLabel infoNameL = new JLabel(" ȫ�浿");
			JLabel infoAgeL = new JLabel(" 23");
			JLabel infoDayL = new JLabel(" ��, ��");
			JLabel infoHourL = new JLabel(" 5�ð�");
			infoNameL.setFont(font);
			infoAgeL.setFont(font);
			infoDayL.setFont(font);
			infoHourL.setFont(font);
			
			infoNameL.setBorder(lb);	
			infoAgeL.setBorder(lb);
			infoDayL.setBorder(lb);
			infoHourL.setBorder(lb);
			
			infoP.add(infoNameL);	infoP.add(infoAgeL);	infoP.add(infoDayL);	infoP.add(infoHourL);
			infoP.setBounds(80, 0, 350, 200);
			
			add(ep);
			add(infoP);
		}
		
	}	//end infoEmployee
	
	//���� ������ - ����, �ʰ��ٹ�
	class InfoEmployee2 extends JPanel {
		
		public InfoEmployee2() {
			String earlyLeave, overtime;	//���� ��ü���� �޾ƿ� ����
			Font font = new Font("���", Font.BOLD, 16);
			LineBorder lb = new LineBorder(Color.BLACK, 1, true);
			
			setLayout(null);
			
			//����, �ʰ��ٹ�
			JPanel ep = new JPanel();
			ep.setLayout(new GridLayout(0, 1, 0, -1));
			JLabel elL = new JLabel("���� ", SwingConstants.RIGHT);
			JLabel otL = new JLabel("�ʰ��ٹ� ", SwingConstants.RIGHT);
			
			//��Ʈ ����
			elL.setFont(font);	
			otL.setFont(font);
			
			//�׵θ� ����
			elL.setBorder(lb);	
			otL.setBorder(lb);
			ep.add(elL);	ep.add(otL);
			ep.setBounds(0, 0, 80, 100);
			
			//�� ��Ͽ� ���� ���� �� ����
			JPanel infoP = new JPanel();
			infoP.setLayout(new GridLayout(0, 1, 0, -1));
			JLabel infoEarlyLeaveL = new JLabel(" ������ -3�ð�");
			JLabel infoOvertimeL = new JLabel(" ������ +3�ð�");
			infoEarlyLeaveL.setFont(font);
			infoOvertimeL.setFont(font);
			
			infoEarlyLeaveL.setBorder(lb);	
			infoOvertimeL.setBorder(lb);
			
			infoP.add(infoEarlyLeaveL);	infoP.add(infoOvertimeL);
			infoP.setBounds(80, 0, 520, 100);
			
			add(ep);
			add(infoP);
		}
		
	}
	
	//���� �̹���
	class EmployeeImage extends JPanel {
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
