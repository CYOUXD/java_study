package day15.generic;
//클래스 선언부에서 generic 지정하기
//1. 클래스의 generic을 지정하기
public class Person_1<E> {//E : Object 타입인 상태. <E extends Object>를 생략한 것.
//<T extends Object>라고 쓰면 Object를 상속 받는 객체 타입과 wrapper 타입만 올 수 있다.
//??????????????? 객체랑 wrapper 타입 말고 뭐가 있는데???
//답 : 잘못 말씀하신 거라고 함
	
	//2. 외부에서 접근할 수 없는 멤버변수 선언
	private E name;
	private int age;
	
	//3. 초기화 생성자 생성
	public Person_1(E name, int age) { //name에는 E타입 만 들어갈 수 있기 때문에 E name
		this.name = name;
		this.age = age;
	}

	
	//4. generic으로 메서드의 유형 매개변수 반환타입 지정하기
	//1) 클래스 선언부에서 정의된 generic 매개변수를 사용하는 방법
	public E getName() {	//getter생성하면 generic이 자동으로 붙어서 나옴
		return name;
	}
	
	//2) 클래스 선언부의 generic과 상관없이 generic 매개변수를 사용하는 방법
	public <T extends Object> T test(T t) {		
		return t;
	}
	//= 매개변수의 반환 타입을 메서드의 반환 타입으로 지정하는 메서드
	//<T extends Object> T 라고 적었을 때 뒤의 T는 메서드 자체의 반환 타입(void, int...)이다.
	//<T extends Object>는 매개변수 T의 범위를 제한하는 것 뿐 실제 반환 타입은 매개변수에서 지정한다.
	//generic은 여러개 써도 된다.
	
	
	public void setName(E name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
