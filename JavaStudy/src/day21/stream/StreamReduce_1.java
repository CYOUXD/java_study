package day21.stream;

import java.util.Arrays;
import java.util.List;

import day20.stream.Circle_1;
import day20.stream.Rectangle_1;
import day20.stream.Shape_1;

public class StreamReduce_1 {
//집계 메서드 : reduce()의 매개변수에 따른 차이
	public static void main(String[] args) {
		Shape_1 s1 = new Rectangle_1(10, 3);
		Shape_1 s2 = new Circle_1(10);
		Shape_1 s3 = new Rectangle_1(20, 2);
		Shape_1 s4 = new Circle_1(11);
		
		List<Shape_1> list = Arrays.asList(s1, s2, s3, s4);
		
		//1. Stream의 집계 메서드 area 기준 정렬
		double areaSum = list.stream().mapToDouble(Shape_1::area).sum();
		System.out.println("sum()을 이용한 면적 합계 : "+areaSum);
		
		//2. reduce() : 매개변수 - DoubleBinaryOperator, 계산식 / 반환타입 - OptionalDouble[]. Stream의 요소들을 하나로 더함. 
		areaSum = list.stream().mapToDouble(Shape_1::area).reduce((a, b) -> a+b).getAsDouble();
		System.out.println("reduce(Operater)를 이용한 면적 합계 : "+areaSum);
		//reduce((a, b) -> a+b) : 두개의 매개변수에 요소 하나씩 값을 넣은 다음 식을 실행, 그 결과 값을 다시 a에 넣고 다음 요소 값을 b에 넣은 후 모든 요소를 반복한다.
		// = reduce(Integer::sum)과 같음
		
		areaSum = list.stream().mapToDouble(Shape_1::area).reduce(0, (a, b) -> a+b);
		System.out.println("reduce(0, Operater)를 이용한 면적 합계 : "+areaSum);
		//reduce(초기값, (a, b) -> a+b) : 초기값을 더하고 위의 식을 똑같이 실행한다.		
		//***reduce((a, b) -> a+b)는 OptionalDouble[]을 반환하기 때문에 getAsDouble이 필요하고 reduce(초기값, (a, b) -> a+b)는 결과 값을 반환하기 때문에 필요 없다.
		
	}

}
