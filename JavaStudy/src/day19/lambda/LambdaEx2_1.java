package day19.lambda;

public class LambdaEx2_1 {
//Runnable 인터페이스를 사용한 람다식 1~10까지 출력하기
//각 스레드별 실행 순서 관찰
	public static void main(String[] args) {
		System.out.println("시작");
		
		//1. Runnable 람다식으로 구현
		Runnable run = () -> {
			for(int i=1; i<=10; i++) {
				System.out.println("첫번째 : "+i);
			}
		};
		
		Runnable run2 = () -> {
			for(int i=1; i<=10; i++) {
				System.out.println("두번째 : "+i);
			}
		};
		
		//2. Thread 사용해서 별개로 동작
		Thread t = new Thread(run);
		Thread t2 = new Thread(run2);
		t.start(); //start() : thread의 메서드
		t2.start();
		System.out.println("종료");
		
	}

}
