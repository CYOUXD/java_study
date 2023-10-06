package day15.compare;

import java.util.HashSet;

//객체간 동등 비교
public class ObjectEqualsExample1_1 {

	public static void main(String[] args) {
		//1. 비교할 객체 생성
		Dog1_1 d1 = new Dog1_1("진돗개", "뽀삐", 15);
		Dog1_1 d2 = new Dog1_1("말티즈", "삐삐", 5);
		Dog1_1 d3 = new Dog1_1("진돗개", "뽀삐", 15);
		
		//2. d1 = d3 ?
		System.out.println(d1 == d3);
		System.out.println(d1.equals(d3));
		System.out.println(d1);
		System.out.println(d3);
		
		//3. hashSet 사용 비교
		HashSet<Dog1_1> set = new HashSet<>();
		System.out.println(set.add(d1));	//동일한 값이 없어서 추가 가능
		System.out.println(set.add(d3));	//이미 동일한 값이 있어서 추가 불가
		
	}

}
