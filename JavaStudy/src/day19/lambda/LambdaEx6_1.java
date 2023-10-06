package day19.lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class LambdaEx6_1 {
//Consumer 인터페이스 람다식 (매개변수O, 리턴값X)
//Consumer의 하위 인터페이스 종류
	public static void main(String[] args) {
		//1. 객체 타입 한개를 매개변수로 사용
		Consumer<String> c1 = name -> System.out.println("제 이름은 "+name+"입니다.");
		c1.accept("홍길동");
		//2. 객체 타입 두개를 매개변수로 사용
		BiConsumer<String, String> c2 = (lastName, firstName) -> {
			System.out.println("제 이름은 "+lastName+firstName+"입니다.");
		};
		c2.accept("홍", "길동");
		//3. 매개변수 값이 double인 경우
		DoubleConsumer c3 = score -> System.out.println("제 점수는 "+score+"입니다.");
		c3.accept(98.6);
		//4. 매개변수 값이 객체와 int인 경우
		//??????????????이름에 Obj와 int라고 써있어서 int는 따로 안써주는건가?
		//답:맞음
		ObjIntConsumer<String> c4 = (lecture, i) -> {
			System.out.println("제 "+lecture+" 점수는 "+i+"점 입니다.");
		};
		c4.accept("영어", 90);
	}

}
