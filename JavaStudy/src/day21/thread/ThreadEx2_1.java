package day21.thread;

public class ThreadEx2_1 {
//Runnable을 Implement하지 않고 바로 Thread 객체 생성	
	public static void main(String[] args) {
		//1. 스레드 생성
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("t1 스레드 시작");
				for(int i=0; i<50; i++) {
					System.out.println("t1 : "+i);
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("t2 스레드 시작");
				for(int i=0; i<50; i++) {
					System.out.println("t2 : "+i);
				}
			}
		});
		
		//2. 스레드 실행
		t1.start();
		t2.start();
	}

}
