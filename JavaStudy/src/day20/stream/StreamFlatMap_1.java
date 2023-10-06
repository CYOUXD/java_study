package day20.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StreamFlatMap_1 {
//flatMapXXX() 메서드 사용
	public static void main(String[] args) {
		//1. List로 Stream 객체 생성 후 나눠서 출력
		List<String> list1 = Arrays.asList("동해물과", "백두산이", "마르고 닳도록");
		list1.stream().flatMap(l -> Arrays.stream(l.split(" "))).forEach(d -> System.out.print(d+" "));
		//flatMap() : 중복 구조로 되어 있는 스트림을 1차원 평면화 시켜줌
		//Arrays.stream(l.split(" "))의 결과  -> ["동해물과", "백두산이", ["마르고", "닳도록"]] 
		//위의 결과를 flatMap을 사용하여 ["동해물과", "백두산이", "마르고", "닳도록"]으로 변환해 준다. 
		//Arrays.stream을 사용한 이유는 split()의 반환 값이 배열이기 때문
		System.out.println();
		
		//2. 문자열을 ","로 분리 후 double 자료형으로 변환
		List<String> list2 = Arrays.asList("1.1, 2.2, 3.3", "4.4, 5.5, 6.6");
//		list2.stream().flatMapToDouble(s -> Arrays.stream(s.split(","))).forEach(d -> System.out.print(d+" "));
		//flatMapToDouble을 사용하려면 double값으로 반환해야 한다.
		DoubleStream dsr = list2.stream().flatMapToDouble(data -> {
			//분리한 배열 저장하기
			String[] strArr = data.split(",");
			//double 타입 배열에 담기
			double[] dArr = new double[strArr.length];
			for(int i=0; i<dArr.length; i++) {
				//double로 변환 후 배열에 넣기
				dArr[i] = Double.parseDouble(strArr[i].trim());
			}
			//??????? flatMapToDouble는 function 람다식을 사용하기 때문에 반드시 매개변수와 반환 값이 있어야한다. < 이거 맞나???
			//double 타입의 배열 스트림을 만들어서 반환
			return Arrays.stream(dArr);
		});
		//출력
		dsr.forEach(d -> System.out.print(d+" "));
		System.out.println();
		
		//3. 문자열을 ","로 분리 후 int 자료형으로 변환
		List<String> list3 = Arrays.asList("1, 2, 3", "4, 5, 6");
		IntStream isr = list3.stream().flatMapToInt(data -> {
			String[] strArr = data.split(",");
			int[] iArr = new int[strArr.length];
			for(int i=0; i<iArr.length; i++) {
				iArr[i] = Integer.parseInt(strArr[i].trim());
			}
			return Arrays.stream(iArr);
		});
		isr.forEach(i -> System.out.print(i+" "));
		
	}

}
