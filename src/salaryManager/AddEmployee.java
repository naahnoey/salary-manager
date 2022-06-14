package salaryManager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//사장 화면에서 직원 추가 버튼 클릭시 나오는 직원 추가창

public class AddEmployee extends JDialog {

	SalaryDao dao = new SalaryDao();	//데이터베이스 불러오기
	ManagerScreen ms;	//부모창 저장 변수
	
	public AddEmployee(JFrame frame, String title) {
		super(frame, title, true);
		ms = (ManagerScreen) frame;	//부모창 저장
		add(new InsertDetail());
		setSize(400, 500);
	}
	
	class InsertDetail extends JPanel {
		
		public InsertDetail() {
			setLayout(null);
			
			//입력해야할 정보 목록
			JPanel ep = new JPanel();
			ep.setLayout(new GridLayout(0, 1, 0, 10));
			JLabel enumL = new JLabel("사번", SwingConstants.RIGHT);
			JLabel nameL = new JLabel("이름", SwingConstants.RIGHT);
			JLabel jobL = new JLabel("담당직무", SwingConstants.RIGHT);
			JLabel hireL = new JLabel("고용일", SwingConstants.RIGHT);
			JLabel accountL = new JLabel("계좌", SwingConstants.RIGHT);
			JLabel hourlyWageL = new JLabel("시급", SwingConstants.RIGHT);
			JLabel workingHourL = new JLabel("노동시간", SwingConstants.RIGHT);
			ep.add(enumL);
			ep.add(nameL);
			ep.add(jobL);
			ep.add(hireL);
			ep.add(accountL);
			ep.add(hourlyWageL);
			ep.add(workingHourL);
			ep.setBounds(0, 0, 100, 400);
			
			//데이터베이스에 입력할 직원 정보
			JPanel infoP = new JPanel();
			infoP.setLayout(new GridLayout(0, 1, 0, 10));
			//입력받는 텍스트 필드
			JTextField enumT = new JTextField(10);
			JTextField nameT = new JTextField(10);
			JTextField jobT = new JTextField(10);
			JTextField hireT = new JTextField(10);
			JTextField accountT = new JTextField(10);
			JTextField hourlyWageT = new JTextField(10);
			JTextField workingHourT = new JTextField(10);
			infoP.add(enumT);
			infoP.add(nameT);
			infoP.add(jobT);
			infoP.add(hireT);
			infoP.add(accountT);
			infoP.add(hourlyWageT);
			infoP.add(workingHourT);
			infoP.setBounds(110, 0, 250, 400);
			
			//확인 버튼 클릭시 입력한 직원 정보가 데이터베이스로 넘어감
			JButton okB = new JButton("확인");
			okB.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//not null 정보 입력시 공백 확인
					String num = enumT.getText();
					if (num.equals("")) {
						JOptionPane.showMessageDialog(null, "사번을 입력하지 않았습니다.", "주의", JOptionPane.ERROR_MESSAGE);
						return;
					}
					String name = nameT.getText();
					if (name.equals("")) {
						JOptionPane.showMessageDialog(null, "이름을 입력하지 않았습니다.", "주의", JOptionPane.ERROR_MESSAGE);
						return;
					}
					String job = jobT.getText();
					String hire = hireT.getText();
					if (hire.equals("")) {
						JOptionPane.showMessageDialog(null, "고용일을 입력하지 않았습니다.", "주의", JOptionPane.ERROR_MESSAGE);
						return;
					}
					String account = accountT.getText();
					int workingHour = Integer.parseInt(workingHourT.getText());
					
					//데이터베이스에 직원 정보 입력
					dao.insertEmployee(num, name, job, hire, account, workingHour);
					ms.updateNumList(num);	//ManagerScreen 리스트 업데이트
					
					dispose();
				}
			});
			okB.setBounds(165, 410, 70, 40);
			
			add(ep);
			add(infoP);
			add(okB);
		}
		
	}
	
}
