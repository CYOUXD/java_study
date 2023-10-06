package day20.stream;

import java.util.Arrays;
import java.util.List;

public class StreamPeek_1 {
//peek() : 중간처리 반복자 
	//forEach()는 반환 값이 void라서 최종 처리 메서드로 쓸 수 있지만 peek()은 stream을 반환해서 불가능함.
	//peek()은 sum, allMatch, noneMatch, anyMatch와 같은 최종 처리 메서드와 함께 써줘야 함.
	public static void main(String[] args) {
		//1. list 생성
		Shape_1 s1 = new Rectangle_1(10, 3);
		Shape_1 s2 = new Circle_1(10);
		Shape_1 s3 = new Rectangle_1(20, 2);
		Shape_1 s4 = new Circle_1(11);
		
		List<Shape_1> list = Arrays.asList(s1, s2, s3, s4);
		
		//2. 모든 넓이 값 더하기
		//???????????????????????? 왜 parallelStream 이거 쓰지?
		//답  : 
		double listSum = list.parallelStream().mapToDouble(a -> a.area())
			.peek(a -> System.out.println(a)).sum();
		System.out.print("area 값 모두 더하기 : ");
		System.out.println(listSum);
	}

}
