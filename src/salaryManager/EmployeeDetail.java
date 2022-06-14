package salaryManager;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

//직원 화면
//자신의 정보 조회 가능 (수정 불가)

public class EmployeeDetail extends JFrame{

	//직원 객체에서 받아온 정보
	String name = null;	//이름
	int age = 0;	//나이
	String day = null;	//출근 요일
	String hour = null;	//노동 시간
	String earlyLeave = null;	//조퇴
	String overtime = null;	//초과근무
	int sal = 0;	//월급
	
	public EmployeeDetail(String id) {
		//데이터베이스에서 id 일치하는 직원 정보 불러와 각각의 멤버변수에 저장
		
		drawPanel();
	}
	
	public EmployeeDetail() {
		// TODO Auto-generated constructor stub
	}

	public void drawPanel() {
		setTitle("월급 관리 프로그램 (직원)");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(680, 550);
		setLocationRelativeTo(this);
		setLayout(null);	//레이아웃 제거
		
		//직원 이미지
		EmployeeImage employeeImage = new EmployeeImage("src//image//img1.png");
		employeeImage.setBounds(30, 30, 150, 200);
		
		//직원 상세정보 - 이름, 나이, 출근요일, 노동시간
		InfoEmployee infoEmployee = new InfoEmployee();
		infoEmployee.setBounds(200, 30, 450, 240);
		
		//직원 상세정보 - 조퇴, 초과근무 기록
		InfoEmployee2 infoEmployee2 = new InfoEmployee2();
		infoEmployee2.setBounds(30, 270, 600, 100);
		
		//월급
		JLabel salL = new JLabel("예상 월급: " + sal + "원");
		salL.setFont(new Font("고딕", Font.BOLD, 16));
		salL.setBounds(470, 380, 200, 50);
		
		//로그아웃 버튼
		JButton logoutB = new JButton("로그아웃");
		logoutB.setBounds(290, 450, 100, 40);
		
		
		add(employeeImage);
		add(infoEmployee);
		add(infoEmployee2);
		add(salL);
		add(logoutB);
		
		setVisible(true);
	}
	
	//직원 상세정보 - 이름, 나이, 출근 요일, 노동 시간
	class InfoEmployee extends JPanel {
		
		public InfoEmployee() {
			Font font = new Font("고딕", Font.BOLD, 16);
			LineBorder lb = new LineBorder(Color.BLACK, 1, true);
			
			setLayout(null);
			
			//이름, 나이, 출근 요일, 노동 시간
			JPanel ep = new JPanel();
			ep.setLayout(new GridLayout(0, 1, 0, -1));
			JLabel nameL = new JLabel("이름 ", SwingConstants.RIGHT);
			JLabel ageL = new JLabel("나이 ", SwingConstants.RIGHT);
			JLabel dayL = new JLabel("출근 요일 ", SwingConstants.RIGHT);
			JLabel hourL = new JLabel("노동 시간 ", SwingConstants.RIGHT);
			
			//폰트 설정
			nameL.setFont(font);	
			ageL.setFont(font);
			dayL.setFont(font);
			hourL.setFont(font);
			
			//테두리 설정
			nameL.setBorder(lb);	
			ageL.setBorder(lb);
			dayL.setBorder(lb);
			hourL.setBorder(lb);
			ep.add(nameL);	ep.add(ageL);	ep.add(dayL);	ep.add(hourL);
			ep.setBounds(0, 0, 80, 200);
			
			//각 목록에 대한 직원 상세 정보
			JPanel infoP = new JPanel();
			infoP.setLayout(new GridLayout(0, 1, 0, -1));
			JLabel infoNameL = new JLabel(" " + name);
			JLabel infoAgeL = new JLabel(" " + age);
			JLabel infoDayL = new JLabel(" " + day);
			JLabel infoHourL = new JLabel(" " + hour);
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
	
	//직원 상세정보 - 조퇴, 초과근무
	class InfoEmployee2 extends JPanel {
		
		public InfoEmployee2() {
			Font font = new Font("고딕", Font.BOLD, 16);
			LineBorder lb = new LineBorder(Color.BLACK, 1, true);
			
			setLayout(null);
			
			//조퇴, 초과근무
			JPanel ep = new JPanel();
			ep.setLayout(new GridLayout(0, 1, 0, -1));
			JLabel elL = new JLabel("조퇴 ", SwingConstants.RIGHT);
			JLabel otL = new JLabel("초과근무 ", SwingConstants.RIGHT);
			
			//폰트 설정
			elL.setFont(font);	
			otL.setFont(font);
			
			//테두리 설정
			elL.setBorder(lb);	
			otL.setBorder(lb);
			ep.add(elL);	ep.add(otL);
			ep.setBounds(0, 0, 80, 100);
			
			//각 목록에 대한 직원 상세 정보
			JPanel infoP = new JPanel();
			infoP.setLayout(new GridLayout(0, 1, 0, -1));
			JLabel infoEarlyLeaveL = new JLabel(" " + earlyLeave);
			JLabel infoOvertimeL = new JLabel(" " + overtime);
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
	
	//직원 이미지
	class EmployeeImage extends JPanel {	//BLOB으로 변경
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
			
			//직원 이미지가 존재하지 않으면 '이미지 없음' 출력
			if (ii == null)	{
				g.drawString("이미지 없음", 45, 105);
				return;
			}
			
			//직원 이미지가 존재하면 Image 객체 생성
			image = ii.getImage();
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}
	
}
