package day20.stream;

import java.util.stream.IntStream;

public class StrToStream_1 {
//IntStream에는 char형을 담을 수 있다.
	public static void main(String[] args) {
		//1. 문자열 생성
		String str = "가나 다 라마 바사";
		
		//2. IntStream 객체 생성
		IntStream isr = str.chars(); //숫자로 변환해서 들어가게 됨
		isr.forEach(s -> System.out.print((char)s+" "));	
	}
}
