package day20.stream;

import java.util.Arrays;
import java.util.List;

public class StreamMap_1 {
//mapToInt() : stream을 intStream으로 변환
	public static void main(String[] args) {
		//1. List 객체 생성
		List<String> list = Arrays.asList("동해물과", "백두산이", "마르고 닳도록");
		
		//2. 배열 값 길이 출력
		System.out.println("함수적 인터페이스 방식");
		list.stream().mapToInt(s -> s.length()).forEach(len -> System.out.print(len+" "));
		System.out.println();
		
		//3. 메서드 참조 방식으로 배열 값 길이 출력
		System.out.println("메서드 참조 방식");
		list.stream().mapToInt(String::length).forEach(len -> System.out.print(len+" "));
		//String::length : 여기의 length는 String 클래스로부터 상속받은 것이다. 이 때 받을 매개변수는 list 내부의 값들로 정해져 있으므로 따로 안 정해줘도 되지만 
		//따로 비교할 매개변수가 필요한 equals와 같은 메서드를 쓸 때 obj::equals(s) 같은 식으로 사용할 수 있다.
	}

}
