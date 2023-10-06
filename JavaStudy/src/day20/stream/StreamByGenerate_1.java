package day20.stream;

import java.util.stream.Stream;

public class StreamByGenerate_1 {
//generate() 메서드를 이용한 Stream 객체 생성
	public static void main(String[] args) {
		//1. Stream 객체 생성
		//generate는 Supplier 인터페이스의 메서드이므로 매개변수 X, 반환값 O
		Stream<String> stream = Stream.generate(() -> "애국가").limit(10);
		
		//2. 내부 반복자 출력
		stream.forEach(s -> System.out.print(s+" "));
	}

}
