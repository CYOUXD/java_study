package day20.stream;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class RandomToStream_1 {
//난수 스트림 생성
	public static void main(String[] args) {
		//1. int형 난수 스트림 생성
		System.out.println("int형 난수 스트림 : ");
		IntStream isr = new Random().ints(3);
		isr.forEach(s -> System.out.print(s+" "));
		System.out.println();
		
		//2. ints(갯수, 시작 값, 끝 값 전(포함X))
		isr = new Random().ints(10, 0, 3);
		isr.forEach(s -> System.out.print(s+" "));
		System.out.println();
		
		//3. longs(갯수, 시작 값, 끝 값 전(포함X))
		System.out.println("long 형 난수 스트림 : ");
		LongStream lsr = new Random().longs(3, 0, 10);
		lsr.forEach(s -> System.out.print(s+" "));
		System.out.println();
		
		//4. double형 난수 스트림 생성
		System.out.println("double형 난수 스트림 : ");
		DoubleStream dsr = new Random().doubles(3);
		dsr.forEach(s -> System.out.print(s+" "));
	}

}
