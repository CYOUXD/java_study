package day17.quiz1;
//User 관련 객체를 생성할 클래스
public class User_1 {
	//1. 개인정보 멤버 변수 생성
	private String name;
	private int age;
	
	//2. 생성자
	public User_1 () {}
	public User_1 (String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//3. getter/setter 생성
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
	
	//4. 출력용 오버라이드
	@Override
	public String toString() {
		return super.toString();
	}
	
}
