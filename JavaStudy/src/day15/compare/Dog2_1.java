package day15.compare;
//객체 크기 비교 : 1)Comparable, 2)comparator를 사용해서 비교
//1) Comparable 인터페이스 구현하여 객체 비교 (별도의 클래스 생성x 기존 클래스 수정o)
//Comparable : 자기 자신과 매개변수로 받은 객체를 비교
					//1. 인스턴스 구현
public class Dog2_1 implements Comparable<Dog2_1>{
	//2. 비교할 멤버변수 생성
	String dogId;
	String dogName;
	int weight;
	
	//3. 객체 생성 시 각 객체의 데이터를 받아 올 생성자 제작
	Dog2_1(String dogId, String dogName, int weight) {
		this.dogId = dogId;
		this.dogName = dogName;
		this.weight = weight;
	}
	
	//4. 데이터 확인을 위한 toString() 오버라이드
	@Override
	public String toString() {
		return "Dog [dogId = "+dogId+", dogName = "+dogName+"]"+this.hashCode();
	}
	
	//5. compareTo() 오버라이드
	//= 자동 정렬 컬렉션의 정렬 조건 재정의
	@Override
	public int compareTo(Dog2_1 o) { //Comparable의 추상 메서드, 값의 자리 하나하나 비교
		//몸무게 비교 후 순서 정렬
		return this.weight - o.weight;	//return 0 = 두 값이 같음, 값 추가 안됨
	}
	
}
