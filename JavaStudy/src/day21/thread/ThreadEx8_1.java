package day21.thread;

public class ThreadEx8_1 {
//join() : 다른 스레드의 실행이 완료될 때까지 기다림
	public static void main(String[] args) {
		//2. 스레드 생성
		Sum t1 = new Sum();
		Sum t2 = new Sum();
		
		//3. 스레드 실행
		t1.start();
		t2.start();
		
		//4. join()로 실행 종료 기다리기
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {}
		
		System.out.println("두 스레드의 sum 합계 = "+(t1.sum + t2.sum));
		//메인 스레드가 t1, t2의 계산이 끝나길 기다린 후 두 스레드의 합계 값을 가져온다.
	}

}

//1. 스레드 상속 클래스 생성
class Sum extends Thread {
	int sum = 0;
	
	@Override
	public void run() {
		for(int i=0; i<=100; i++) {
			sum += i;
		}
	}
}
