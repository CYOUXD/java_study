package day20.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntStreamEx_1 {
//IntStream의 range(), rangeClosed() 메서드 사용
	public static void main(String[] args) {
		//1. 배열 생성
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		//2. stream()으로 Stream 생성
		System.out.println("Arrays.stream() IntStream 생성하기");
		IntStream intstream1 = Arrays.stream(arr);
		intstream1.forEach(s -> System.out.print(s+" "));
		System.out.println();
		
		//3. of()로 Stream 생성
		System.out.println("IntStream.of() IntStream 생성하기");
		IntStream intstream2 = IntStream.of(arr);
		intstream2.forEach(s -> System.out.print(s+" "));
		System.out.println();
		
		//4. range()로 stream 생성
		System.out.println("IntStream.range(10,16) IntStream 생성하기");
		IntStream intstream3 = IntStream.range(10, 16);//마지막 값 포함X
		intstream3.forEach(s -> System.out.print(s+" "));
		System.out.println();
		
		//5. rangeClosed()로 stream 생성
		System.out.println("IntStream.range(10,15) IntStream 생성하기");
		IntStream intstream4 = IntStream.rangeClosed(10, 15);//마지막 값 포함O
		intstream4.forEach(s -> System.out.print(s+ " "));
		
	}

}
