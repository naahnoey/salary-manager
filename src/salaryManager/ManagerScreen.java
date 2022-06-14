package salaryManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


//사장 화면 구현

public class ManagerScreen extends JFrame {
	//JList로 직원 목록 생성
	//목록 중 하나 선택시 해당 직원 정보 출력 - EmployeeDetail 클래스 이용
	
	JFrame frame = this;
	SalaryDao dao = new SalaryDao();
	Vector<String> numV = new Vector<String>();	//직원 사번 저장 벡터
	JList<String> numList = new JList<String>(numV);
	
	Container c = getContentPane();	//ManagerScreen 창
	EmployeeDetail ed = new EmployeeDetail();
	
	public ManagerScreen() {
		setTitle("월급 관리 프로그램 (사장)");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(850, 550);
		setLocationRelativeTo(this);
		
		c.setLayout(new BorderLayout());	//레이아웃 설정
		
		c.add(new ListPanel(), BorderLayout.WEST);
		c.add(ed, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	//직원 리스트
	//직원 추가, 삭제, 수정 버튼
	private class ListPanel extends JPanel {
		//직원 목록 출력
		//데이터베이스에서 사번 가져와 JList에 아이템 제공
		
		public ListPanel() {
			setLayout(new BorderLayout(0, 10));
			
			//데이터베이스에서 직원 목록 불러와 사번 벡터에 저장
			try {
				ResultSet rs = dao.managerInquiry();
				while(rs.next()) {
					numV.add(rs.getString("enum"));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			numList.setListData(numV);	//직원 목록으로 사용할 리스트 생성
			
			JLabel label = new JLabel("직원 목록");
			numList.setVisibleRowCount(10);	//목록에서 보여지는 직원 수
			numList.setFixedCellWidth(100);
			numList.setFixedCellHeight(30);
			
			//리스트에서 직원 선택시 해당 직원 정보 출력
			numList.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					c.remove(ed);	//이전 직원 상세 정보 없애기
					
					String num = numList.getSelectedValue();	//클릭된 사번
					ed = new EmployeeDetail(num);	//해당 직원의 상세 정보
					
					c.add(ed, BorderLayout.CENTER);
					c.repaint();
				}
			});
			
			//직원 추가 다이얼로그
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
			add(new JScrollPane(numList), BorderLayout.CENTER);
			add(buttonP, BorderLayout.SOUTH);
		}
	}
	
	//Dao에서 직원 사번 받아와 numList 업데이트
	public void updateNumList(String num) {
		numV.add(num);
		numList.setListData(numV);
	}
	
}
