package day14.collection;

import java.util.LinkedList;

public class LinkedListExample_1 {
//LinkedList : 추가, 삭제가 빈번할 때 사용. 큐와 리스트의 구현체
	public static void main(String[] args) {
		//이렇게 사용하면 LinkedList의 메서드를 사용할 수 없음
		//List<String> list = new LinkedList<>(); 
		LinkedList<String> list = new LinkedList<>();
		
		//addFirst, addLast
		list.add("hello");
		list.add("java");
		list.add("banana");
		list.addFirst("apple");
		list.addLast("zoo");
		System.out.println("list data : "+list);
		
		//remove : 인덱스 값 삭제
		list.remove(); //비워두면 제일 앞 값 삭제
		System.out.println("list data after remove : "+list);	
		list.remove(2);
		System.out.println("list data after remove(2) : "+list);
		
		//set : 수정
		list.set(1, "new element");
		System.out.println("list data after set : "+list);
		
		//peek : 조회
		String str1 = list.peek();	//생략하면 첫번째 조회
		String str2 = list.peekLast();
		System.out.println("str1 : "+str1);
		System.out.println("str2 : "+str2);
		System.out.println("list data after peek() : "+list);
		
		//poll : 조회 후 삭제
		String str3 = list.poll(); //= pop()
		System.out.println("str3 : "+str3);
		System.out.println("list data after poll() : "+list);
		
		//pop : 조회 후 삭제
		String str4 = list.pop(); //= poll()
		System.out.println("str4 : "+str4);
		System.out.println("list data after pop() : "+list);
		
		//push : 앞에 추가, add는 뒤에 추가 됨
		list.push("push element");
		System.out.println("list data after push() : "+list);
		
	}

}
