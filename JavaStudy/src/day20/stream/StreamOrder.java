package day20.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamOrder {
//sorted() : Stream 요소 정렬
	public static void main(String[] args) {
		//1. List 생성
		List<String> list = Arrays.asList("홍길동", "김유신", "이순신", "유관순");
		
		//2. 기본 정렬
		System.out.println("기본 정렬");
		list.stream().sorted().forEach(System.out::println);
		//내부의 요소는 String인데 String은 이미 Comparable을 구현하고 있어서 바로 비교 가능
		
		//3. 역순 정렬
		System.out.println("역순 정렬");
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		//스트림 기본 정렬 sorted(), 역순 정렬 sorted(Comparator.reverseOrder())
		//스트림에서는 Comparator를 구현한 클래스가 없어도 sorted() 사용 가능
		//???????????????? 왜? 왜 그냥 사용 가능한데??
		//답 : 
	}

}
