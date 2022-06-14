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

//���� ȭ�鿡�� ���� �߰� ��ư Ŭ���� ������ ���� �߰�â

public class AddEmployee extends JDialog {

	SalaryDao dao = new SalaryDao();	//�����ͺ��̽� �ҷ�����
	ManagerScreen ms;	//�θ�â ���� ����
	
	public AddEmployee(JFrame frame, String title) {
		super(frame, title, true);
		ms = (ManagerScreen) frame;	//�θ�â ����
		add(new InsertDetail());
		setSize(400, 500);
	}
	
	class InsertDetail extends JPanel {
		
		public InsertDetail() {
			setLayout(null);
			
			//�Է��ؾ��� ���� ���
			JPanel ep = new JPanel();
			ep.setLayout(new GridLayout(0, 1, 0, 10));
			JLabel enumL = new JLabel("���", SwingConstants.RIGHT);
			JLabel nameL = new JLabel("�̸�", SwingConstants.RIGHT);
			JLabel jobL = new JLabel("�������", SwingConstants.RIGHT);
			JLabel hireL = new JLabel("�����", SwingConstants.RIGHT);
			JLabel accountL = new JLabel("����", SwingConstants.RIGHT);
			JLabel hourlyWageL = new JLabel("�ñ�", SwingConstants.RIGHT);
			JLabel workingHourL = new JLabel("�뵿�ð�", SwingConstants.RIGHT);
			ep.add(enumL);
			ep.add(nameL);
			ep.add(jobL);
			ep.add(hireL);
			ep.add(accountL);
			ep.add(hourlyWageL);
			ep.add(workingHourL);
			ep.setBounds(0, 0, 100, 400);
			
			//�����ͺ��̽��� �Է��� ���� ����
			JPanel infoP = new JPanel();
			infoP.setLayout(new GridLayout(0, 1, 0, 10));
			//�Է¹޴� �ؽ�Ʈ �ʵ�
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
			
			//Ȯ�� ��ư Ŭ���� �Է��� ���� ������ �����ͺ��̽��� �Ѿ
			JButton okB = new JButton("Ȯ��");
			okB.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//not null ���� �Է½� ���� Ȯ��
					String num = enumT.getText();
					if (num.equals("")) {
						JOptionPane.showMessageDialog(null, "����� �Է����� �ʾҽ��ϴ�.", "����", JOptionPane.ERROR_MESSAGE);
						return;
					}
					String name = nameT.getText();
					if (name.equals("")) {
						JOptionPane.showMessageDialog(null, "�̸��� �Է����� �ʾҽ��ϴ�.", "����", JOptionPane.ERROR_MESSAGE);
						return;
					}
					String job = jobT.getText();
					String hire = hireT.getText();
					if (hire.equals("")) {
						JOptionPane.showMessageDialog(null, "������� �Է����� �ʾҽ��ϴ�.", "����", JOptionPane.ERROR_MESSAGE);
						return;
					}
					String account = accountT.getText();
					int workingHour = Integer.parseInt(workingHourT.getText());
					
					//�����ͺ��̽��� ���� ���� �Է�
					dao.insertEmployee(num, name, job, hire, account, workingHour);
					ms.updateNumList(num);	//ManagerScreen ����Ʈ ������Ʈ
					
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
