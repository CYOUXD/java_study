package day21.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamConcat_1 {
//concat() : 두 개의 스트림 객체를 연결해서 새로운 스트림 객체 생성
	public static void main(String[] args) {
		//1. 문자열 스트림 생성
		Stream<String> stream1 = Stream.of("홍길동", "김유신", "이순신", "유관순");
		//Stream.of와 Arrays.asList의 차이점
//		List<String> stream1 = Arrays.asList("홍길동", "김유신", "이순신", "유관순");
		//Arrays.asList는 List를 만들 때 쓴다
		
		//2. 정수 스트림 객체
		Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		//3. 두 스트림 연결해서 새로운 스트림 만들기
		Stream<Object> concat = Stream.concat(stream1, stream2);
		concat.forEach(a -> System.out.print(a+=" "));
	}

}
