package day19.lambda;
//람다식으로 더하기 만들기
public class LambdaFunctionEx_1 {

	public static void main(String[] args) {
		//2. 람다식으로 표현
		InterfaceEx ie = (int x, int y) -> x+y;
		System.out.println(ie.sum(1, 2));
		
		//3. 기본 자바 표현 - 인터페이스 익명 클래스
		InterfaceEx ie2 = new InterfaceEx() {
			@Override
			public int sum(int x, int y) {
				return x+y;
			}
		};
		System.out.println(ie2.sum(1, 2));
		
	};

}

//1. 람다식 표현할 인터페이스 생성
//추상메서드가 하나만 있는 함수적 인터페이스
interface InterfaceEx{
	public int sum(int x, int y);
}