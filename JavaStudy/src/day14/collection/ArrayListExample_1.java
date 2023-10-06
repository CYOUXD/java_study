package day14.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample_1 {
//List 객체 예제 순서 O, 중복 허용 O
	public static void main(String[] args) {
		List list = new ArrayList();
		
		//add - 추가
		list.add("one");
		boolean a = list.add("second"); //추가에 성공하면 true, 실패하면 false
		list.add("3rd");
		list.add(new Integer(4));
		list.add(new Float(5.0f)); //float 실수형
		boolean b = list.add("second"); //중복 허용
		list.add(new Integer(4));
		list.add("SECOND");
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(list);
		
		//set - 수정
		list.set(6, 8);
		System.out.println(list);
		
		//remove - 제거
		list.remove(0);	//인덱스
		//?????????? 그럼 int를 삭제하려면 어떻게 해야 하지?
		//답 : 
		list.remove("SECOND"); //오브젝트
		System.out.println(list);
		
		//get : 가져오기
		Object o = list.get(5); //인덱스
		System.out.println(o);
		
		//size : 길이, indexOf : 인덱스 번호
		int i = list.size();
		int idx = list.indexOf("second");
		System.out.println("list 크기는 "+i);
		System.out.println("second = "+idx);
		String s = (String)list.get(4); //리스트 내부의 객체이기 때문에 String으로 바꿔서 사용할 수 있다.
		System.out.println("문자열의 길이 = "+s.length());
		
		//clear : 지우기, 정리
		list.clear();
		if(list.isEmpty()) {
			System.out.println("list is Empty!");
		}
		
	}

}
