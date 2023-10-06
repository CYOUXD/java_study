package day21.thread;

public class ThreadEx5_1 {
//sleep() : () 시간만큼 일시 정지
	public static void main(String[] args) {
		//1. 스레드 생성
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					System.out.println("t1 : "+i);
					//2. sleep() : 예외 체크
					try {
						Thread.sleep(1000); //해당 스레드 1초 일시정지 = 1초마다 실행
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
					
				}
				System.out.println("스레드 실행 종료");
			}
		});
		t1.start();
	}

}
