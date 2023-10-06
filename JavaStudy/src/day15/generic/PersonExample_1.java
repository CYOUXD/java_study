package day15.generic;
//반환 타입이 지정된 클래스의 메서드를 사용
public class PersonExample_1 {

	public static void main(String[] args) {
		//1. 반환 타입이 지정된 클래스 객체 생성
		Person_1<Character> p1 = new Person_1<>('딸', 8);
		Person_1<String> p2 = new Person_1<String>("엄마", 40);
		
		//2. 출력
		System.out.println(p1.getName());
		System.out.println(p2.getName());
		
		//3. 메서드 자체의 반환타입과 입력 값에 대한 반환 타입을 지정
		System.out.println(p1.test(4.8));	//double : 입력 값의 타입이 메서드의 반환타입이 됨
		System.out.println(p1.test("4.8"));	//String
		System.out.println(p1.test(5));		//Integer
		System.out.println(p1.test('5'));	//char
	}

}
