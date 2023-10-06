package day15.compare;

import java.util.TreeSet;

//객체 크기 비교 : 1)Comparable, 2)comparator를 사용해서 비교
//2) comparator를 사용해서 객체 비교 (별도의 클래스 생성o 기존 클래스 수정x)
public class ComparatorExample1_1 {
	public static void main(String[] args) {
		//1. 비교할 객체 생성
		Employee_1 e1 = new Employee_1("홍길동", 20000);
		Employee_1 e2 = new Employee_1("김찬중", 30000);
		Employee_1 e3 = new Employee_1("허길자", 70000);
		Employee_1 e4 = new Employee_1("이순신", 40000);
		
		//2. 정렬 기준을 만든 클래스를 사용해서 TreeSet 생성
		TreeSet<Employee_1> list = new TreeSet<>(new EmployeeComparator_1());
		//comparator를 이용한 정렬을 할 때 Comparator를 구현한 클래스를 정렬할 리스트를 생성 할 때 생성자로 넣어서 사용
		//***생성자에 비교 조건 구현 클래스를 추가하지 않으면 cast되지 않아서 비교할 수 있는 내용이 없다는 오류가 생김
		//?????????????????????? 무슨 말인지 잘 이해가 안됨...
		//답 : 
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		
		//3. 비교 후 정렬 된 list 출력
		for(Employee_1 s : list) {
			System.out.println(s);
		}		
	}
}
