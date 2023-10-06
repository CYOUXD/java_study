package day21.thread;

public class ThreadEx6_1 {
//interrupt() : 스레드가 일시 정지 상태에 있을 때 InturruptException 예외 발생 시켜 스레드를 정상 종료시킨다.
	public static void main(String[] args) {
		//1. 스레드 생성
		Thread t1 = new Thread(() -> {
			//2. interrupt() 예외 처리
			try {
				int i = 1;
				while(true) {
					System.out.println("t1 : "+i);
					Thread.sleep(1000);
					i++;
				}
				
			} catch (InterruptedException e) {
				System.out.println("스레드 내에서 일시정지 : "+e.getMessage());
			}
			System.out.println("스레드 실행 종료");
		});
		
		t1.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e2) {
			System.out.println("메인에서 일시정지 : "+e2.getMessage());
		}
		
		t1.interrupt();
		//메인 스레드 순서대로 실행되니까 10초 sleep한 다음 t1.interrupt()가 실행되는데 그 때 t1이 일시정지 상태라면 interruptedException을 발생시켜 정상 종료 시킴
		//메인 스레드는 interrupt()가 마지막이니까 알아서 종료
	}

}
