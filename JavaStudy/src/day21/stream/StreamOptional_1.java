package day21.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class StreamOptional_1 {
//집계 함수 : 첫번째, 평균, 최대, 최소 등을 구할 수 있음. OptionalXXX[] 타입으로 리턴
	public static void main(String[] args) {
		//1. 배열 생성
		int arr[] = new int[100];
		for(int i=0; i<100; i++) {
			arr[i] = i+1;
		}
		
		//2. 요소들의 갯수 구하기
		long count = Arrays.stream(arr).count();
		//count() : long 리턴, IntStream의 메서드
		System.out.println("요소들의 갯수 : "+count);
		
		//3. 요소들의 합 구하기
		int sum = Arrays.stream(arr).sum();
		//sum() : int 리턴, IntStream의 메서드
		System.out.println("요소들의 합 : "+sum);
		
		//4. 요소들 중 첫번째 값 구하기
		OptionalInt first = Arrays.stream(arr).findFirst();
		//findFirst() : OptionalInt의 첫번째 값을 가져옴 = OptionalInt[1];
		/*
		 * Optional<T>와 OptionalInt의 차이
		 * Optional<T>은 T타입의 객체를 감싸는 wrapper 클래스. 모든 타입의 참조 변수를 담을 수 있음
		 * 최종 연산의 결과를 Optional 객체에 담아서 반환. 반환된 결과가 null인지 체크하지 않고 Optional에 정의된 메서드로 처리 가능
		 * NullPointException이 발생하지 않는 코드 작성 가능
		 * 참고  : https://velog.io/@injoon2019/%EC%9E%90%EB%B0%94-OptionalT%EC%99%80-OptionalInt
		 */
		System.out.println("요소들 중 첫번째 값 : "+first.getAsInt());
		//OptionalInt로 넘어간 값(OptionalInt[1])은 getAsInt()로 가져온다
		
		//5. 요소들 중 최대 값 구하기
		OptionalInt max = Arrays.stream(arr).max();
		System.out.println("요소들 중 최대 값 : "+max.getAsInt());
		//max, min, average 메서드 들이 OptionalInt의 메서드이기 때문에 OptionalInt로 받는다.
		
		//6. 요소들 중 최소 값 구하기
		OptionalInt min = Arrays.stream(arr).min();
		System.out.println("요소들 중 최소 값 : "+min.getAsInt());
		
		//7. 요소들의 평균 값 구하기
		OptionalDouble avg = Arrays.stream(arr).average();
		System.out.println("요소들 중 평균 값 : "+avg.getAsDouble());
		//average() : double 리턴
		
		
		
		System.out.println("Optional 주요 메서드 확인");
		//8. 빈 List 만들기
		List<Integer> list = new ArrayList<>();
		
		//9. 요소들의 갯수 구하기
		long count1 = list.stream().count();
		System.out.println("요소들의 갯수 :"+count1);
		
		//10. 요소들의 합 구하기
		long sum1 = list.stream().mapToInt(Integer::intValue).sum();
		// mapToInt(Integer::intValue) = mapToInt(i -> i.intValue())
		//***Stream<Integer> 타입이므로 안에 Integer객체가 있음. 객체는 바로 계산 할 수 없기 때문에 mapToInt로 int형으로 변환해야 함
		//mapToInt() : Stream<Integer>를 기본형인 IntStream으로 변환
		//intValue() : Integer의 값을 반환 
		//참고 : https://peonyf.tistory.com/entry/Stream
		System.out.println("요소들의 합 : "+sum1);
		
		//11. 요소가 존재하는경우에만 평균을 출력
		OptionalDouble avg2 = list.stream().mapToDouble(Integer::intValue).average();
		if(avg2.isPresent()) { 
			//isPresent() : 있다면. 존재하면 true
			//isEmpty() : 없다면. java 11 이상
			System.out.println("요소들의 평균 : "+avg2);			
		}
		
		//12. 요소가 존재하는 경우에만 최대 값을 출력
		OptionalInt max2 = list.stream().mapToInt(Integer::intValue).max();
		if(max2.isPresent()) {
			System.out.println("요소들 중 최대 값 : "+max2.getAsInt());
		}
		
		//13. 요소가 존재하는 경우에만 최소 값을 출력
		int min2 = list.stream().mapToInt(Integer::intValue).min().orElse(0);
		//orElse() : 값이 없다면 ()안의 값을 기본값으로 반환한다.
		//orElse()의 반환 타입이 int이기 때문에 OptionalInt로 받을 수 없음
		System.out.println("요소들 중 최소 값 : "+min2);
		
		//14. 요소가 존재하는 경우에만 첫번째 값을 출력
		//OptionalInt first2 = list.stream().mapToInt(Integer::intValue).findFirst()
		list.stream().mapToInt(Integer::intValue).findFirst()
			.ifPresent(a -> System.out.println("요소들 중 첫번째 값 : "+a));
		//ifPresent() : 매개변수 Consumer. 반환타입이 void이기 때문에  OptionalInt first2로 값을 넘길 수 없음
		
	}

}
