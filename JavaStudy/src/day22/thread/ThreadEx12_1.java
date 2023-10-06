package day22.thread;

public class ThreadEx12_1 {
//DaemonThread : 주로 무한 실행을 하면서 일반 스레드를 보조하는 스레드. 일반 스레드가 종료되면 함께 종료
	//스레드 실행 전 데몬 스레드로 설정되어야 한다.
	//예제 더 찾아보기 보조하고 같이 종료된다는게 잘 와닿지 않음
	public static void main(String[] args) {
		//2. 스레드 객체 생성
		DaemonThread dt1 = new DaemonThread();
		DaemonThread dt2 = new DaemonThread();
		
		//3. 데몬 스레드 설정
		dt1.setDaemon(true);
		dt2.setDaemon(true);
		
		//4. 스레드 실행
		dt1.start();
		dt2.start();
		
		//5. 메인 스레드 종료
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		
		System.out.println("메인 스레드 종료");
	}

}

//1. 데몬클래스로 사용할 클래스 생성
class DaemonThread extends Thread {
	@Override
	public void run() {
		while(true) {
			System.out.println(getName()); //Thread를 상속받았으므로 Thread의 메서드 바로 사용 가능
			try {
				sleep(500);
			} catch (InterruptedException e) {}
		}
	}
}