package day20.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CollectionToStream_1 {
//Collection을 Stream 객체로 변환
	public static void main(String[] args) {
		//1. 문자열 배열 객체 생성
		String[] arr = new String[] {"a", "b", "c", "d", "e", "f"};
		
		//2. 문자열 배열을 Collection(List) 객체로 변환
		List<String> list = Arrays.asList(arr);
		
		//3. Collection(List) 객체를 Stream 객체로 변환
		Stream<String> stream = list.stream();
		
		//4. 내부 반복자를 이용해 출력
		stream.forEach(s -> System.out.print(s+" "));

	}

}
