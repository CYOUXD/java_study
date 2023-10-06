package day21.thread;

public class ThreadEx_1 {
//Thread 생성 방법 - 1) Thread 클래스 상속  2) Runnable 인터페이스 구현 후 Thread에 전달
	public static void main(String[] args) {
		//1-2. Thread 클래스 상속 
		ThreadExtend t1 = new ThreadExtend();
		
		//2-2. Runnable 인터페이스를 구현하고 Thread에 집어 넣기
		Runnable r = new RunnableImplement();
		Thread t2 = new Thread(r);
		
		//3. Thread 실행
		//start() : 스레드 생성, 실행(멀티 스레드)
		t1.start();
		t2.start();		
	}

}

//1-1. Thread 클래스 상속
class ThreadExtend extends Thread {
	//2. run() 오버라이드
	//run() : Thread가 실행 될 때 실행되는 메서드(싱글 스레드)
	@Override
	public void run() {
		System.out.println("Thread 상속 받는 방법");
		for(int i=0; i<50; i++) {
			System.out.println("ThreadExtend : "+i);
		}
	}
	
}

//2-1. Runnable 인터페이스 구현 후 전달
class RunnableImplement implements Runnable {
	@Override
	public void run() {
		System.out.println("Runnable 구현하는 방법");
		for(int i=0; i<50; i++) {
			System.out.println("RunnableImplement : "+i);			
		}
	}
}
