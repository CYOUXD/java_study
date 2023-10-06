package day20.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class IteratorEx_1 {
//리스트를 이용한 스트림 생성
	//내,외부 반복자 - for(), iterator(), forEach()
	public static void main(String[] args) {
		//1. list 생성 - Arrays.asList : 배열을 리스트로 만듦
		List<String> list = Arrays.asList(new String[] {
				"홍길동", "김유신", "이순신", "유관순"
		});
		
		//2. for문 list 출력
		System.out.println("for문 이용");
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i));
		}
		System.out.println();
		
		//3. iterator() list 출력
		System.out.println("외부 반복자 이용");
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.print(it.next());
		}
		System.out.println();
		
		//4. forEach() list 출력
		System.out.println("내부 반복자 이용");
		list.stream().forEach(s -> System.out.print(s));
		//stream() : 컬렉션 스트림 객체 생성
	}

}
