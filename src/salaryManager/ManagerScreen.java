package salaryManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;

//사장 화면 구현

public class ManagerScreen extends JFrame {
	//JList로 직원 목록 생성
	//목록 중 하나 선택시 해당 직원 정보 출력 - EmployeeDetail 클래스 이용
	
	JFrame frame = this;
	
	public ManagerScreen() {
		setTitle("월급 관리 프로그램 (사장)");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(850, 550);
		setLocationRelativeTo(this);
		
		setLayout(new BorderLayout());	//레이아웃 설정
		
		add(new ListPanel(), BorderLayout.WEST);
		add(new EmployeeDetail(), BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	//직원 리스트
	//직원 추가, 삭제, 수정 버튼
	private class ListPanel extends JPanel {
		//직원 목록 출력
		//데이터베이스에서 이름과 id 가져와 JList에 아이템 제공
		
		//직원 이름, id 저장 리스트
		Vector<String> nameV = new Vector<String>();
		JList<String> nameList = new JList<String>(nameV);
		
		public ListPanel() {
			setLayout(new BorderLayout(0, 10));
			JLabel label = new JLabel("직원 목록");
			nameList.setVisibleRowCount(10);	//목록에서 보여지는 직원 수
			nameList.setFixedCellWidth(100);
			nameList.setFixedCellHeight(30);
			
			//직원 추가창
			AddEmployee addEmployee = new AddEmployee(frame, "직원 추가");
			
			//버튼 패널
			JPanel buttonP = new JPanel();
			//추가 버튼
			JButton addB = new JButton("추가");
			addB.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 버튼 클릭 시 추가 다이얼로그 뜨게 함
					addEmployee.setVisible(true);
				}
			});
			
			//삭제 버튼
			JButton delB = new JButton("삭제");
			//수정 버튼
			JButton corB = new JButton("수정");
			buttonP.add(addB);
			buttonP.add(delB);
			buttonP.add(corB);
			
			add(label, BorderLayout.NORTH);
			add(new JScrollPane(nameList), BorderLayout.CENTER);
			add(buttonP, BorderLayout.SOUTH);
		}
	}
	
}
