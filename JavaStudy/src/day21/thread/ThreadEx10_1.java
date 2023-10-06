package day21.thread;

public class ThreadEx10_1 {
//***동기화 - 여러 스레드가 동일한 자원에 접근하여 사용하는 경우 서로 영향을 줄 수 있는 상황이 됨
//			때문에 동기화를 통해서 사용하는 자원에 접근을 제한하여 작업이 종료되기 전에 접근할 수 없게 하는 것!
	public static void main(String[] args) {
		//4. 게임 객체 생성
		SmartPhoneGame game = new SmartPhoneGame();
		
		//5. 플레이어 객체 생성 후 스레드 실행
		Player1 p1 = new Player1();
		p1.setSmartPhoneGame(game); //SmartPhoneGame 객체인 game
		p1.start();
		
		Player2 p2 = new Player2();
		p2.setSmartPhoneGame(game); 
		p2.start();
	}

}

//1. 공유 자원 생성 - 스마트폰 게임 클래스
class SmartPhoneGame {
	private int level;
	
	//private용 getter
	public int getLevel() {
		return this.level;
	}
	//3. 공유 메서드에 synchronized를 설정 (1),(2)
//	public synchronized void increaseLevel() {  (1) 메서드 동기화 방법
	public void increaseLevel() {
		 synchronized (this) { 	// (2) 블록 설정 방법
		//this = SmartPhoneGame 클래스	
			 while(true) {
				this.level++;
				try {
					Thread.sleep(1000); //1초마다 1레벨 업
				} catch (InterruptedException e) {}
				
				//현재 실행중인 스레드의 이름과 레벨 출력
				System.out.println(Thread.currentThread().getName()+" Level : "+this.level);
				
				//5레벨이 되면 
				if(this.level ==5) {
					notifyAll(); //모두를 깨우고	// 현재 대기 상태인 모든 스레드를 실행 중 상태로 전환, 우선순위 영향 O
//					notify();					// 현재 대기 상태인 스레드들 중 하나만 실행 중으로 상태 전환(실행 할 스레드 직접 지정 불가, 우선순위 영향 X)
					
					try {
						wait();//정지한다.			// 현재 실행 중인 스레드를 대기 상태로 전환		//wait이 걸리는 순간 다른 스레드가 작동할 수 있다.
					} catch (InterruptedException e) {}
					break;
				}
				//레벨이 10의 배수가 되면 종료 = 10이 되면 종료
				if(this.level%10 ==0) break;
			 }
		}						// (2) 동기화 블럭 끝
	}	
}

//2. 플레이어 클래스 생성
//플레이어 1
class Player1 extends Thread {
	private SmartPhoneGame game; //SmartPhoneGame 타입의 game 필드
	//????????? 이걸 왜 이렇게 넣었을까?
	//답 : game으로 공유자원인 SmartPhoneGame의 increaseLevel()의 메서드를 사용하기 위해서 사용함.
	
	public void setSmartPhoneGame(SmartPhoneGame game) {
		this.setName("Player1");
		//setName() : Thread의 메서드. Thread의 이름을 매개변수의 값으로 바꿈.
		this.game = game;
	}
	@Override
	public void run() {
		//공유자원 메서드 실행
		game.increaseLevel();
	}
	
}

//플레이어 2
class Player2 extends Thread {
	private SmartPhoneGame game;

	public void setSmartPhoneGame(SmartPhoneGame game) {
		this.setName("Player2"); //setName : 스레드 이름
		this.game = game;
	}
	@Override
	public void run() {
		game.increaseLevel();
	}	
}