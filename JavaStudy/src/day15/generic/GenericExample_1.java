package day15.generic;

import java.util.ArrayList;
//객체 생성시 generic 지정
//generic을 사용하여 타입 지정하기
public class GenericExample_1 {

	public static void main(String[] args) {
		//1. generic 적용할 컬렉션 리스트 만들기
		ArrayList list = new ArrayList<>();	//generic 생략 = Object
		ArrayList<String> genericList = new ArrayList<>();
		
		//2. 각 리스트에 적절한 타입 데이터 넣기
		list.add("first");
		list.add("second");
		list.add("third");
		list.add(new Integer(4)); // = list.add(4);
		list.add(new Float(5.0f)); // = list.add(5.0f);
		
		//generic이 String이므로 문자열만 들어갈 수 있음
		genericList.add("first");
		genericList.add("second");
		genericList.add("third");
		
		//3. 첫번째 배열 출력하기
		//Object 타입이기 때문에 String으로 캐스팅 해줘야 함
		String s1 = (String)list.get(0);
		
		//<String>이므로 캐스팅 필요 없음
		String s2 = genericList.get(0);
		
		System.out.println(s1);
		System.out.println(s2);
		
		//4. genericList 전체 출력
		for(String s : genericList) {
			System.out.println(s);
		}
		
		
	}

}
