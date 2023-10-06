package day20.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArrayToStream_1 {
//배열로 스트림 생성하기
	public static void main(String[] args) {
		//1. 문자열 배열 객체 생성
		String[] arr = new String[] {"a", "b", "c", "d", "e", "f"};
		
		//이건 문자열 리스트 객체 생성
//		List<String> arr1 = Arrays.asList({"a", "b", "c", "d", "e", "f"});
		//위 처럼 넣으면 안됨!! asList의 매개변수에는 배열 객체가 들어가야 함
//		List<String> arr1 = Arrays.asList(new String[] {"a", "b", "c", "d", "e", "f"});
		//이렇게 넣어주는건 괜찮음
		
		//2. 스트림 객체로 변환하기
		Stream<String> stream1 = Arrays.stream(arr);
		//3. 리스트 출력하기
		stream1.forEach(s -> System.out.print(s+" "));
		System.out.println();
		
		//4. 인덱스를 지정해서 반환(2~5전까지) - 두번째 인덱스는 포함x
		Stream<String> stream2 = Arrays.stream(arr, 2, 5);
		stream2.forEach(s -> System.out.print(s+" "));
		
	}

}
