package day22.thread;

public class ThreadEx13_1 {
//ThreadGroup : 관련된 스레드들끼리 분류한다. 그룹 안에 그룹 O, 내 그룹이나 하위 그룹 변경 O, 다른 그룹 변경 X 
	public static void main(String[] args) {
		//2. 스레드 그룹 객체 생성 - 만들어 놓은 클래스 생성자의 매개변수로 사용
		ThreadGroup group = new ThreadGroup("Group1"); //그룹 이름 입력
		MyThread t1 = new MyThread(group, "First");
		MyThread t2 = new MyThread(group, "Second");
		MyThread t3 = new MyThread(group, "Third");
		
		//3. 스레드 실행
		t1.start();
		t2.start();
		t3.start();
		
		//4. 메인 스레드 정지
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		//5. 모든 스레드 정지
		group.interrupt();		
	}

}

//1. 스레드 클래스 생성
class MyThread extends Thread {
	//ThreadGroup의 생성자를 이용하여 그룹화 하기 위한 생성자
	public MyThread(ThreadGroup group, String name) {
		super(group, name);
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println(getName());
			try {
				sleep(500);
			} catch (InterruptedException e) {
				System.out.println(getName() + " interrupted 발생");
				break;
			}
		}
		System.out.println(getName()+" 종료");
	}
}