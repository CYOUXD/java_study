package day20.stream;

import java.util.Arrays;

public class StreamOther_1 {
//asDoubleStream() : 스트림을 doubleStream으로 형변환. doubleStream이기 때문에 내부 값도 double형
//boxed() : int -> Integer, long -> Long, double -> Double
	public static void main(String[] args) {
		//1. 배열 생성
		int intArr[] = {10, 20 , 30 , 40 , 50, 60};
		
		//2. doubleStream으로 형변환
		Arrays.stream(intArr).asDoubleStream().forEach(d -> System.out.print(d+" "));
		//  intStream	 ->		doubleStream
		System.out.println();
		
		//3. boxed()로 형변환
		Arrays.stream(intArr).asDoubleStream().boxed().forEach(i -> System.out.print(i+" "));
		//asDoubleStream()를 빼면 int -> Integer로 바뀜. 캐스팅
		//boxed() : intStream -> Stream<Integer>로 변환
		//????????????????? Stream<Integer>랑 intStream이랑 뭐가 다르지??
		//답 : intStream = 원시타입 스트림, Stream<Integer> = 클래스 타입 스트림
		//답 : intStream은 요소가 int 타입이고 Stream<Integer>의 요소는 Integer타입이다
	}

}
