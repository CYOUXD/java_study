package day21.thread;

public class ThreadEx7_1 {
//스레드에 sleep()을 사용하지 않고 interrupt()로 중지 
	public static void main(String[] args) {
		//1. 스레드 생성
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i=1;
				while(true) {
					System.out.println("t1 : "+i);
					i++;
					//2. 스레드 중지 조건 설정
					if(Thread.interrupted()) {
						break;
					}
				}
				System.out.println("스레드 실행 종료");
			}
		});
		
		//3. 스레드 실행
		t1.start();
		
		try {
			Thread.sleep(5000); //메인 스레드 sleep
		} catch (InterruptedException e) {}
		
		//4. t1 스레드 interrupt()
		t1.interrupt();
	} 

}
