package day20.stream;

import java.util.stream.Stream;

public class StreamByBuilder_1 {
//builder() 메서드를 이용한 Builder 객체 생성
	public static void main(String[] args) {
		//1. builder() 메서드를 사용한 Builder 스트림 객체 생성
		Stream stream = Stream.builder()
				.add("무궁화")
				.add("삼천리")
				.add("화려강산")
				.add("대한사람")
				.build();
		
		//2. 내부 반복자로 출력
		stream.forEach(s -> System.out.println(s+ " "));
	}

}
