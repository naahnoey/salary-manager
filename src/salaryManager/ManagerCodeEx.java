package salaryManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerCodeEx {
//	사장 로그인 시 전체 데이터를 뽑는게 초기에 계획했던 것 처럼 직원 선택 식으로 나오는걸 구현하기가 쉽지 않을듯 합니다 ㅠㅠ
//	현재 방식대로 긴 목록으로 한번에 출력하는게 최선일듯 해요 ㅠㅠ
	public void printManagerScreen() {
		ResultSet rs = null;

		salaryDao sd = new salaryDao();

		rs = sd.managerInquiry();

		try {
			while (rs.next()) {
//				출력 결과: 사번, 이름, 직무, 고용일시, 퇴직일시, 계좌번호, 시급, 근무시간, 월급
				System.out.printf(
						"사번: %s \n이름: %s \n직무: %s \n고용일시: %s \n퇴직일시: %s \n계좌번호: %s \n시급: %d \n월간 근무시간: %d \n월급: %d",
						rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
				System.out.println("\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
