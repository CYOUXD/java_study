package day14.collection;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HashSetExample_1 {
//HashSet : Set(순서 X, 중복 X) 하나의 문자열을 보다 빨리 찾을 수 있도록 주소에 직접 접근할 수 있는 짧은 길이의 값이나 키로 변환
	public static void main(String[] args) {
		Set set = new HashSet<>();
		
		set.add("three");
		set.add("one");
		set.add("two");
		set.add("four");
		set.add("five");
		set.add(new Integer(4));
		boolean isAdded = set.add("five"); //중복 X
		
		System.out.println(set);
		System.out.println(isAdded);
		
		System.out.println(set.size());
		
		set.remove("two");
		System.out.println(set);
		
		set.clear();
		System.out.println(set);
		
		if(set.isEmpty()) {
			System.out.println("set is Empty!");
		}
		
		//로또 번호 만들기
		while(set.size() < 6) {
			Random ran = new Random();
			int num = (int)ran.nextInt(44)+1;
			set.add(num);
		}
		System.out.println(set);
	}

}
