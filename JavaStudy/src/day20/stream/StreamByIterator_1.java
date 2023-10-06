package day20.stream;

import java.util.stream.Stream;

public class StreamByIterator_1 {
//Iterate() 메서드를 이용한 Stream 객체 생성
	public static void main(String[] args) {
		//1. Stream 객체 생성
		Stream<Integer> stream = Stream.iterate(1, n -> n+1).limit(10);
//		iterate(시드 값, Operator); 시드 값(시작 값)을 Operator가 매개변수(n)로 받아서 연산(n+1)한 값을 "매개변수에 반환".
		
		//2. 내부 반복자 출력
		stream.forEach(s -> System.out.print(s+" "));
	}

}
