package day19.lambda;

public class LambdaEx5_1 {
//Consumer 인터페이스 람다식 (매개변수O, 리턴값X)
//람다식에서의 this의 위치
	public static void main(String[] args) {
		Outer o = new Outer();
		o.method();
	}

}
//1. 인터페이스 생성
@FunctionalInterface
interface LambdaInterface5{
	void method();
}

class Outer{
	public int iv = 10;
	void method() {
		//2. 익명 로컬 클래스 생성
		final int iv = 40;
		LambdaInterface5 f5 = () -> {
			//Outer의 this
			System.out.println("Outer.this.iv : "+Outer.this.iv); //10
			//람다식의 this
			System.out.println("this.iv : "+this.iv);//10
			//final int iv
			System.out.println("iv : "+iv);//40
		};
		f5.method(); //인터페이스의 method()를 재정의;
		//???????????? 엥??? Outer의 method랑 LambdaInterface5의 method랑 같은건가?????
		//답: 인터페이스의 추상메서드를 Outer안의 method()에서 익명 클래스로 재정의 함. Outer의 메서드는 main에서 사용됨
	}
}