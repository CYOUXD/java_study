package day19.lambda;

public class LambdaEx_1 {
//람다식은 함수적 인터페이스만 사용할 수 있다.
	public static void main(String[] args) {
		LambdaInterface li = () -> {
			String str = "메서드 출력";
			System.out.println(str);
		};
		li.print();
	}
}

interface LambdaInterface{
	void print();
//	void print2(); //함수적 인터페이스는 추상메서드가 하나만 존재한다.
}