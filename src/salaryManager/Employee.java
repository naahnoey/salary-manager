package salaryManager;

//직원 객체 클래스

public class Employee {

	String name;	//이름
	int age;	//나이
	String day;	//출근 요일
	String hour;	//노동 시간
	String earlyLeave;	//조퇴
	String overtime;	//초과근무
	int wage;	//시급
	int sal;	//월급
	
	public Employee() {}

	public Employee(String name, int age, String day, String hour, String earlyLeave, String overtime, int wage, int sal) {
		super();
		this.name = name;
		this.age = age;
		this.day = day;
		this.hour = hour;
		this.earlyLeave = earlyLeave;
		this.overtime = overtime;
		this.wage = wage;
		this.sal = sal;
	}

	//Getter, Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getEarlyLeave() {
		return earlyLeave;
	}
	public void setEarlyLeave(String earlyLeave) {
		this.earlyLeave = earlyLeave;
	}
	public String getOvertime() {
		return overtime;
	}
	public void setOvertime(String overtime) {
		this.overtime = overtime;
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	
}
