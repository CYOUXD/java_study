package day19.lambda;

public class LambdaEx4_1 {
//람다식으로 두 수 사이여 여러가지 연산하기
	public static void main(String[] args) {
		//2. 두 수의 곱
		LambdaInterface4 f4 = (x, y) -> {
			return x * y;
		};
		System.out.println("두 수의  : "+f4.cal(3, 2));
		//3. 두 수의 합
		f4 = (x, y) -> x+y;
		System.out.println("두 수의 합 : "+f4.cal(3, 2));
		//4. 두 수의 몫
		f4 = (x, y) -> {return x/y;};
		System.out.println("두 수의 몫 : "+f4.cal(5, 2));
		//5. 두 수의 나머지
		f4 = (x, y) -> x%y;
		System.out.println("두 수의 나머지 : "+f4.cal(5, 2));
		//6. 두 수의 합 : 메서드를 따로 만들어서 가져와 사용하기
		f4 = (x, y) -> sum(x, y);
		System.out.println("두 수의 합(sum) : "+f4.cal(3, 2));
		//?????????????? 마지막에 cal을 쓸건데 람다식에서는 sum을 쓰는 이유가 뭐지??? 
		//답: f4.cal(3, 2)에서 배개변수를 받아 람다식을 표현한 곳으로 보내면 sum()이 있어서 거기서 sum()을 실행하게 되어 출력한다. 
	}
	static int sum(int x, int y) {
		return x+y;
	}

}
//1. 람다식으로 사용할 인터페이스 생성
@FunctionalInterface
interface LambdaInterface4{
	int cal(int x, int y);
}