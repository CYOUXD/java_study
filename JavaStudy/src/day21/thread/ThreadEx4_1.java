package day21.thread;

public class ThreadEx4_1 {
//setPriority() : 스레드 우선순위 설정
	public static void main(String[] args) {
		//1. 스레드 생성
		Thread t1 = new Thread(() -> {
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
		
		//2. 우선순위 설정 - 최대 10, 최소 1 / 스레드 실행 전에 설정해야 한다.
		t1.setPriority(7);
		t2.setPriority(3);
		
		//Thread.MAX_PRIORIRY	: 10
		//Thread.NORM_PRIORIRY	: 5
		//Thread.MIN_PRIORIRY	: 1
		
		//3. 스레드 실행
		t1.start();
		t2.start();
	}

}
