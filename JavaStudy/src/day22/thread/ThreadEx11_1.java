package day22.thread;

public class ThreadEx11_1 {
//synchronized 예제
	//공유 자원을 반환할 때까지 기다리는 메서드
	public static void main(String[] args) {
		//4. 통장 객체 생성
		Account acc = new Account();
		
		//5. 엄마 스레드 생성
		Mother mom = new Mother(acc);
		
		//6. 딸 스레드 생성
		Doughter ddal = new Doughter(acc);
		
//		mom.setDaemon(true);
//		ddal.setDaemon(true);
		
		
		//7. 스레드 시작
		mom.start();
		ddal.start();
		
		//8. 메인 스레드 10초 후 종료
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {}
		
		//9. 모든 스레드 종료
		mom.interrupt();
		ddal.interrupt();
		
		System.out.println("메인 스레드 종료");
		//????????? 메인 스레드가 끝났는데 왜 아들 스레드가 실행되지?
		//답 : 동기화로 공유 자원을 사용중이기 때문에 마지막으로 사용할 때까지 기다려준다.
		//멀티 스레드인 경우 메인 스레드가 작업 스레드보다 먼저 종료되어도 작업 스레드가 실행 중이라면 프로세스는 종료되지 않음
		//???????????데몬스레드로 설정해도 같이 종료가 안되는데? 원래 그런가????
		//답 : interrupt()를 삭제하면 됨
	}

}

//1. 통장 클래스 - 공유 자원
class Account{
	//synchronized 메서드 들의 공유 필드
	int money;
	//싱크로 메서드들이 공통으로 사용하는 필드
	//싱크로 메서드 안에서 사용하는 필드기 때문에 처음 필드를 가져간 싱크로 메서드에서 다 쓸 때끼지 다른 싱크로 메서드는 대기해야 한다.
	
	//입급
	synchronized void deposit() {
		while(money > 0) { //돈이 남아 있으면 멈춤
			try {
				wait();
			} catch (InterruptedException e) {
				break;
			}			
		}
		//랜덤 입금 1~5만원
		money = (int)((Math.random()*5)+1)*10000;
		notifyAll();
		System.out.println();
		System.out.println(Thread.currentThread().getName()+money+"원 입금");
	}
	
	//출금
	synchronized void withdraw() {
		//?????????? if - return으로 하면 안되나? 어차피 메서드는 다른 클래스에서 계속 실행되고 여기는 한번만 실행되도 되잖아?
		//답 : 
		while(money == 0) { //찾을 돈이 0원이 되면  = main이 종료 되서 엄마 스레드가 종료되면
			//????????????? 어차피 interrupt()로 종료 되면 그대로 종료 아닌가? 왜 필요하지?
			//답 : 
			try {
				wait(); //메서드를 일시 정지하고
			} catch (InterruptedException e) {
				break; 	//나간다.
			}
		}
		notifyAll(); //정지한 다른 메서드를 깨운다.
		//????notifyAll()은 정지한 스레드가 있을 때만 실행되나? 
		//답 : 정지한 스레드가 있으면 깨우는 거고 없으면 그냥 지나간다.
		//돈이 있을 때 나는 아직 멈추지 않았는데 이걸로 엄마 스레드를 깨우면 아랫줄이 실행이 되나?? 싱크로니까 전부 실행하고 공유 필드를 반환하고 나야 깨어난 엄마 스레드가 실행되는건가?
		//답 : 엄마 스레드를 깨웠지만 아직 공유자원을 반환하지 않아서 엄마 스레드는 아직 실행되지 않음.
		System.out.println(Thread.currentThread().getName()+money+"원 출금");
		money = 0;
	}	
}

//2. 엄마 스레드
class Mother extends Thread {
	//통장 클래스 객체 생성한 것을 담을 필드 - 통장의 메서드를 사용하기 위해 필요
	Account account;
	
	public Mother(Account account) {
		super("엄마"); 
		//??????? Thread의 어떤 생성자에 전달하는거지?
		//답 : Thread(String name) 여기로 전달 됨
		this.account = account;		
	}
	@Override
	public void run() {
		while(true) {
			try {
				account.deposit();
				sleep((int)(Math.random()*2000)); //입금 후 랜덤 대기
			} catch (InterruptedException e) {
				break;
			}
		}
	}
}


//3. 딸 스레드
class Doughter extends Thread {
	Account account;
	
	public Doughter(Account account) {
		super("딸");
		this.account = account;
	}
	@Override
	public void run() {
		while(true) {
			try {
				account.withdraw();
				sleep((int)(Math.random()*300)); //출금 후 랜덤 대기
			} catch (InterruptedException e) {
				break;
			} 
		}
	}
	
}
