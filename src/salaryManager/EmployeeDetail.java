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

//직원 화면
//자신의 정보 조회 가능 (수정 불가)

public class EmployeeDetail extends JPanel{

	//직원 객체에서 받아온 정보
	String num = null;	//사번
	String name = null;	//이름
	String job = null;	//직무
	int hour = 0;	//노동 시간
	String hire = null;	//고용일시
	String account = null;	//계좌번호
	int sal = 0;	//월급
	
	SalaryDao dao = new SalaryDao();
	
	public EmployeeDetail() {//아무 직원도 선택되지 않았을 때
		this(null);
	}
	
	public EmployeeDetail(String num) {
		//데이터베이스에서 사번 일치하는 직원 정보 불러와 각각의 멤버변수에 저장
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
		setLayout(null);	//레이아웃 제거
		
		//직원 이미지
		EmployeeImage employeeImage = new EmployeeImage("src//image//img1.png");
		employeeImage.setBounds(30, 30, 150, 200);
		
		//직원 상세정보 - 이름, 나이, 출근요일, 노동시간
		InfoEmployee infoEmployee = new InfoEmployee();
		infoEmployee.setBounds(200, 30, 450, 240);
		
		//직원 상세정보 - 고용일시, 계좌번호
		InfoEmployee2 infoEmployee2 = new InfoEmployee2();
		infoEmployee2.setBounds(30, 270, 600, 100);
		
		//월급
		JLabel salL = new JLabel("예상 월급: " + sal + "원");
		salL.setFont(new Font("고딕", Font.BOLD, 16));
		salL.setBounds(470, 380, 200, 50);
		
		//로그아웃 버튼
		JButton logoutB = new JButton("로그아웃");
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
	
	//직원 상세정보 - 이름, 나이, 출근 요일, 노동 시간
	class InfoEmployee extends JPanel {
		
		public InfoEmployee() {
			Font font = new Font("고딕", Font.BOLD, 16);
			LineBorder lb = new LineBorder(Color.BLACK, 1, true);
			
			setLayout(null);
			
			//사번, 이름, 직무, 노동 시간
			JPanel ep = new JPanel();
			ep.setLayout(new GridLayout(0, 1, 0, -1));
			JLabel numL = new JLabel("사번 ", SwingConstants.RIGHT);
			JLabel nameL = new JLabel("이름 ", SwingConstants.RIGHT);
			JLabel jobL = new JLabel("직무 ", SwingConstants.RIGHT);
			JLabel hourL = new JLabel("노동 시간 ", SwingConstants.RIGHT);
			
			//폰트 설정
			numL.setFont(font);
			nameL.setFont(font);
			jobL.setFont(font);
			hourL.setFont(font);
			
			//테두리 설정
			numL.setBorder(lb);
			nameL.setBorder(lb);	
			jobL.setBorder(lb);
			hourL.setBorder(lb);
			ep.add(numL);	ep.add(nameL);	ep.add(jobL);	ep.add(hourL);
			ep.setBounds(0, 0, 80, 200);
			
			//각 목록에 대한 직원 상세 정보
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
	
	//직원 상세정보 - 고용일시, 계좌번호
	class InfoEmployee2 extends JPanel {
		
		public InfoEmployee2() {
			Font font = new Font("고딕", Font.BOLD, 16);
			LineBorder lb = new LineBorder(Color.BLACK, 1, true);
			
			setLayout(null);
			
			//조퇴, 초과근무
			JPanel ep = new JPanel();
			ep.setLayout(new GridLayout(0, 1, 0, -1));
			JLabel hireL = new JLabel("고용일시 ", SwingConstants.RIGHT);
			JLabel accountL = new JLabel("계좌번호 ", SwingConstants.RIGHT);
			
			//폰트 설정
			hireL.setFont(font);	
			accountL.setFont(font);
			
			//테두리 설정
			hireL.setBorder(lb);	
			accountL.setBorder(lb);
			ep.add(hireL);	ep.add(accountL);
			ep.setBounds(0, 0, 80, 100);
			
			//각 목록에 대한 직원 상세 정보
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
