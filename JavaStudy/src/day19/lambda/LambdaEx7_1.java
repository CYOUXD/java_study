package day19.lambda;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class LambdaEx7_1 {
//Supplier 인터페이스 람다식(매개변수X, 리턴값O)
	public static void main(String[] args) {
		//1. 이름 반환
		Supplier<String> s1 = () -> {
			return "홍길동";
		};
		System.out.println(s1.get());
		
		s1 = () -> "이순신"; //실행문이 한 줄이고 중괄호가 생략되면 return도 생략해야 한다.
		System.out.println(s1.get());
		
		//2. 랜덤 주사위 숫자 반환
		IntSupplier s2 = () -> {
//			int num = (int)(Math.random()*6)+1;
//			return num;
			return (int)(Math.random()*6)+1;
		};
		System.out.println("랜덤 주사위 숫자 : "+s2.getAsInt());
		//3. 파이 값 반환
//		DoubleSupplier s3 = () -> {
//			return Math.PI;
//		};
		DoubleSupplier s3 = () -> Math.PI;
		System.out.println("파이 값 : "+s3.getAsDouble());
	}

}
