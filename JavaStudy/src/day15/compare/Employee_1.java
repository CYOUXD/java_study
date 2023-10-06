package day15.compare;
//객체 크기 비교 : 1)Comparable, 2)comparator를 사용해서 비교
//2) comparator를 사용해서 객체 비교 (별도의 클래스 생성o 기존 클래스 수정x)
public class Employee_1 {
	//1. 비교할 멤버 변수 생성
	String name;
	int salary;
	
	//2. 객체 생성 시 각 객체의 데이터를 받아 올 생성자 제작
	public Employee_1() {}	//혹시 모를 오류 방지 기본 생성자
	
	public Employee_1(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	//3. 데이터 확인을 위한 toString() 오버라이드
	@Override
	public String toString() {
		return name+" : "+salary;
	}
}
