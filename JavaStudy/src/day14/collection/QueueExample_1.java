package day14.collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample_1 {
//Queue : 선입 선출
	public static void main(String[] args) {
		//인터페이스라서 객체 생성이 안되서 하위의 LinkedList로 객체를 생성한다.
		Queue<Integer> qu = new LinkedList<>();
		
		qu.add(1);
		qu.offer(2); //queue의 맨 뒤에 삽입
		qu.add(3);
		qu.add(4);
		
		System.out.println(qu.toString());
		System.out.println(qu.remove(2)); // 같은 값 삭제
		System.out.println(qu.toString());
		System.out.println();
		
		while(!qu.isEmpty()) {
			System.out.println(qu.poll());
		}
	}

}
