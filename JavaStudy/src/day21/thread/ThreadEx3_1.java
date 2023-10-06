package day21.thread;

public class ThreadEx3_1 {
//Runnable을 Implement하지 않고 바로 Thread 객체 생성 + 람다식 표현	
	public static void main(String[] args) {
		//1. 스레드 생성 + 람다식
		//Runnable의 추상메서드인 run()을 람다식으로 표현
		Thread t1 = new Thread(() -> { //run()에 매개변수가 없으므로 ()를 비워둔다.
			System.out.println("t1 스레드 시작");
			for(int i=0; i<50; i++) {
				System.out.println("t1 : "+i);
			}
		});
		
		Thread t2 = new Thread(() -> {
			System.out.println("t2 스레드 시작");
			for(int i=0; i<50; i++) {
				System.out.println("t2 : "+i);
			}
		});
		
		//2. 스레드 실행
		t1.start();
		t2.start();
	}

}
