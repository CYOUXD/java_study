package day20.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamOrder2_1 {
//Shape 객체 비교, 정렬
	public static void main(String[] args) {
		//각 도형의 area 기준 비교, 정렬
		//1. Shape 객체 생성
		Shape_1 s1 = new Rectangle_1(10, 3);
		Shape_1 s2 = new Circle_1(10);
		Shape_1 s3 = new Rectangle_1(20, 2);
		Shape_1 s4 = new Circle_1(11);
		
		List<Shape_1> list = Arrays.asList(s1, s2, s3, s4);
		
		//2. 오름차순 정렬
		System.out.println("오름차순 정렬");
		list.stream().sorted().forEach(System.out::println);
		//= list.stream().sorted().forEach(s -> System.out.println(s));
		//sorted() = a.compareTo(b) 만 동작하는 것과 같음
		
		//3. 내림차순 정렬1
		System.out.println("내림차순 정렬");
		list.stream().sorted((a, b) -> b.compareTo(a) - a.compareTo(b)).forEach(System.out::println);
		//b.compareTo(a) = b - a =10   a.compareTo(b) = a - b = -10  -> 10 - (-10) = 20(양수) = a, b 자리 바꿈
		//a는 Shape_1로 만들었기 때문에 compareTo를 쓸 수 있고 a가 this가 된다.
		
		//4. 내림차순 정렬2
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		//5. length 기준으로 비교, 정렬하고 싶을 때!
		System.out.println("둘레(length()) 순으로 정렬");
		System.out.println("함수적 인터페이스로 구현");
		list.stream().sorted(new Comparator<Shape_1>() {
			@Override
			public int compare(Shape_1 o1, Shape_1 o2) {
				return (int)(o1.length() - o2.length());
			}
		}).forEach(System.out::println);
		//함수적 인터페이스는 추상메서드를 하나만 가지고 있는건데 Comparator는 두 개 이상인데 왜 함수적 인터페이스라고 하지?
		//답 : equals는 Object의 public 함수이기 때문에 제외한다. 그러면 추상메서드는 compare() 하나만 남게되어 함수적 인터페이스가 된다.
		
		System.out.println("람다 표현식을 이용하여 둘레순으로 정렬");
		list.stream().sorted((a, b) -> (int)(a.length() - b.length())).forEach(System.out::println);
		
	}

}
