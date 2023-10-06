package day20.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilterStream_1 {
//FilterStream 메서드 연습
	public static void main(String[] args) {
		//1. List 객체 생성
		List<String> list = Arrays.asList("홍길동", "김유신", "홍길동", "이순신", "홍길동", "유관순");
		
		//2. 중복 제거 - distinct()
		System.out.println("distinct()");
		list.stream().distinct().forEach(n -> System.out.print(n+" "));
		System.out.println();
		
		//3. "홍"으로 시작하는 문자열 필터링 - filter()
		System.out.println("filter() - '홍'으로 시작하는 문자열 필터링");
		list.stream().filter(n -> n.startsWith("홍")).forEach(n -> System.out.print(n+" "));
		System.out.println();
		
		//중복 제거 + "홍"으로 시작하는 문자열 필터링
		System.out.println("distinct() + filter()");
		list.stream().distinct().filter(n -> n.startsWith("홍")).forEach(n -> System.out.print(n+" "));

	}

}
