package day20.stream;

import java.util.Arrays;
import java.util.List;

public class StreamMatch_1 {
//Stream 내부의 요소 조건 검사하기
	
	public static void main(String[] args) {
		//	allMatch(Predicate p) : 요소들이 모두 p 조건을 만족하면 true, 그렇지 않으면 false
		//	anyMatch(Predicate p) : 요소들 중 하나라도 p 조건을 만족하면 true, 그렇지 않으면 false
		//	noneMatch(Predicate p) : 요소들 모두 p 조건을 만족하지 않으면 true, 하나라도 만족하면 false
		// 모두 boolean 리턴
		
		//1. list 생성
		Shape_1 s1 = new Rectangle_1(10, 3);
		Shape_1 s2 = new Circle_1(10);
		Shape_1 s3 = new Rectangle_1(20, 2);
		Shape_1 s4 = new Circle_1(11);
		
		List<Shape_1> list = Arrays.asList(s1, s2, s3, s4);
		
		//1. 모든 요소들이 Shape_1의 인스턴스(객체)인지 조건 비교
		boolean result = list.stream().allMatch(a -> (a instanceof Shape_1));
		//클래스를 비교해야 하니 instanceof 사용
		System.out.println("모든 요소는 Shape의 객체 입니다. -> "+result);
		
		//2. 요소들 중에서 하나 이상이 Rectangle 객체인지 조건 비교
		boolean result2 = list.stream().anyMatch(a -> (a instanceof Rectangle_1));
		//?????????????? 왜 Shape_1 확인하는거랑 같지?
		//답 : Shape_1를 상속받았기 때문에 true 반환함. 단, "부모 instanceof 자식"인 경우 false 리턴 
		//instanceof : 객체 타입을 확인, 형 변환 가능 여부 확인
		System.out.println("요소들 중 Rectangle의 객체가 존재합니다. -> "+result2);
		
		//3. 모든 요소중 Circle의 객체가 존재하지 않는지 조건 비교
		boolean result3 = list.stream().noneMatch(a -> (a instanceof Circle_1));
		System.out.println("요소들 중 Circle의 객체가 존재하지 않는다. -> "+result3);
	}

}
