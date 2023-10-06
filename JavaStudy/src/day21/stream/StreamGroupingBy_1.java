package day21.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import day20.stream.Circle_1;
import day20.stream.Rectangle_1;
import day20.stream.Shape_1;

public class StreamGroupingBy_1 {
//GroupingBy() : Map 객체로 생성!
	public static void main(String[] args) {
		Shape_1 s1 = new Rectangle_1(10, 3);
		System.out.println("s1(Rectangle)의 getClass 값 : "+s1.getClass());
		Shape_1 s2 = new Circle_1(10);
		Shape_1 s3 = new Rectangle_1(20, 2);
		Shape_1 s4 = new Circle_1(11);
		
		List<Shape_1> list = Arrays.asList(s1, s2, s3, s4);
		
		//Class 클래스를 사용하려면 ClassNotFoundException 처리를 해야 하기 때문에 try - catch를 쓴다.
		try {
			//1. map 으로 그룹핑
			Map<Object, List<Shape_1>> map = list.stream().collect(Collectors.groupingBy(s -> s.getClass()));
			//class로 그룹핑하면 class가 키 값이 된다. 그러므로 제너릭이 Object여야 함
			//키 값은 getClass()한 값이고 value 값은 list의 요소인 클래스 그 자체가 된다.
			//키 : Rectangle, Circle / value : list 내부의 값 Rectangle(10, 3);, Rectangle(20, 2); / Circle(10);, Circle(11);
			//Collectors.groupingBy(Shape_1::getClass) 라고 하려면 Shape_1에 getClass 메서드가 있어야 한다. 위의 s.getClass()는 Object의 클래스임
			System.out.println("사각형 출력");
			
			//2. 만들어진 map에 특정 클래스의 값만 출력
			map.get(Class.forName("day20.stream.Rectangle_1")).stream().forEach(f -> System.out.println(f));
			map.get(Class.forName("day20.stream.Circle_1")).stream().forEach(f -> System.out.println(f));

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
