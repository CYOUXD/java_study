package day19.lambda;

public class LambdaEx3_1 {
//람다식 간소화
	public static void main(String[] args) {
		LambdaInterface3 li3 = (String name) -> {
			System.out.println("제 이름은 "+name+"입니다.");
		};
		li3.print("홍길동");
		
		//2. 자료형 , 소괄호 생략
		LambdaInterface3 li4 = name -> {
			System.out.println("제 이름은 "+name+"입니다.");
		};
		li4.print("이순신");
	}

}
//1. 람다식을 사용할 인터페이스 생성
@FunctionalInterface
interface LambdaInterface3 {
	void print(String name);
}