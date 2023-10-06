package day14.collection;

import java.util.Stack;

public class StackExample_1 {
//Stack
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.add(1);
		st.push(2);
		st.add(3);
		st.push(4);
		//??????????add는 뒤에 추가하는거고 push는 앞에 추가하는건데 왜 순서대로 나오지?
		//답 : 
		
		System.out.println(st.toString());
		System.out.println(st.get(0));
		System.out.println(st.search(1));
		System.out.println();
		
		while(!st.isEmpty()) {
			System.out.println(st.pop()); //후입선출
		}
	}

}
