package day21.thread;

public class ThreadEx9_1 {
//yield() : 동일한 우선순위를 가진 다른 메서드에게 실행 양보
	public static void main(String[] args) {
		//2. 스레드 생성
		YieldThread t1 = new YieldThread();
		YieldThread t2 = new YieldThread();
		
		//3. 스레드 실행
		t1.start();
		t2.start();
		
		//4. 메인 스레드 1초 일시정지
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		//5. t1 양보
		t1.isContinue = false; //t1이 양보 = yield() 실행됨
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		//6. t1이 다시 실행
		t1.isContinue = true;
		
		//7. 스레드 종료
		t1.isBreak = true;
		t2.isBreak = true;
		
	}

}
//1. 스레드 상속 클래스 생성
class YieldThread extends Thread {
	//실행중인지 아닌지 반환할 필드 값 생성
	boolean isBreak = false;
	boolean isContinue = true;
	
	@Override
	public void run() {
		while(!isBreak) { //isBreak가 true가 될 때까지 실행
			if(isContinue) { //isContinue가 true면
				try {
					Thread.sleep(100);
					System.out.println(getName() + " 실행 중"); 
					//getName() : Thread getter, Thread의 이름
				} catch (Exception e) {}
			}else {
				Thread.yield(); //Thread의 continue가 true면 계속 실행하고 아니면 양보한다.
			}
		}
		System.out.println(getName() + " 종료");
	}
}

