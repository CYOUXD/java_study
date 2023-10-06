package day21.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import day20.stream.Circle_1;
import day20.stream.Rectangle_1;
import day20.stream.Shape_1;

public class StreamCollect_1 {
//collect() : 요소들을 필터링을 하거나 매핑한 후 새로운 객체를 생성
	public static void main(String[] args) {
		Shape_1 s1 = new Rectangle_1(10, 3);
		Shape_1 s2 = new Circle_1(10);
		Shape_1 s3 = new Rectangle_1(20, 2);
		Shape_1 s4 = new Circle_1(11);
		
		List<Shape_1> list = Arrays.asList(s1, s2, s3, s4);
		
		//요소가 Rectangle_1이면 List로 변환
		List<Shape_1> rectList = list.stream().filter(s -> s instanceof Rectangle_1).collect(Collectors.toList());
		//Collectors.toList() : Collector 모든 입력 요소를 새 목록으로 생성
		rectList.stream().forEach(System.out::println);
		
		System.out.println();
		
		//요소가 Rectangle 이면 Set으로 변환
		Set<Shape_1> rectSet = list.stream().filter(s -> s instanceof Rectangle_1).collect(Collectors.toSet());
		rectSet.stream().forEach(s -> System.out.println(s)); 
//		rectSet.forEach(s -> System.out.println(s));
		//위의 forEach는 Stream의 메서드 아래는 Iterable의 메서드 
		
		
	}

}
