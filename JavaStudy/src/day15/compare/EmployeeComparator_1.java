package day15.compare;

import java.util.Comparator;

//객체 크기 비교 : 1)Comparable, 2)comparator를 사용해서 비교
//2) comparator를 사용해서 객체 비교 (별도의 클래스 생성o 기존 클래스 수정x)
//comparator : 매개변수로 받은 두 객체를 비교

//비교 조건을 담은 별도의  클래스(= 정렬 기준)  //1. 비교할 객체를 생성할 클래스의 제너릭을 가진 Comparator 구현
public class EmployeeComparator_1 implements Comparator<Employee_1> {

	//2. compare() 오버라이드
	@Override
	public int compare(Employee_1 o1, Employee_1 o2) {
		//3. 이름 비교, 정렬하기
		return o1.name.compareTo(o2.name);
		//??????????????????? Comparable을 구현하지 않았는데 왜 compareTo를 쓸 수 있지?
		//답 : String 클래스가 Comparable을 implement하고 있고 compareTo를 이미 재정의 한 상태이기 때문에 사용할 수 있다.
	}
}
