package day15.compare;

import java.util.TreeSet;

//객체 크기 비교
//1) Comparable 인터페이스 구현하여 객체 비교 (별도의 클래스 생성x 기존 클래스 수정o)
public class ObjectEqualsExample2_1 {

	public static void main(String[] args) {
		//1. 비교할 객체 생성
		Dog2_1 d1 = new Dog2_1("진돗개", "뽀삐", 15);
		Dog2_1 d2 = new Dog2_1("말티즈", "삐삐", 5);
		Dog2_1 d3 = new Dog2_1("진돗개", "뽀삐", 15);
		
		//2. TreeSet 비교, 정렬 할 객체 추가
		TreeSet<Dog2_1> tset = new TreeSet<Dog2_1>();
		System.out.println(tset.add(d1));
		System.out.println(tset.add(d2));
		
		//3. 객체 비교, 정렬
		for(Dog2_1 dog : tset) {	//test에 들어 있는 객체가 Dog2_1
			System.out.println(dog);
		}
	}

}
