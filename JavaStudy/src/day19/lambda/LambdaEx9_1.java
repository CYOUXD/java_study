package day19.lambda;

import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;

public class LambdaEx9_1 {
//Operator 인터페이스 람다식(매개변수O, 반환값O(연산 결과))
	//1. 학생 정보를 리스트에 담기
	static Student[] list = {
			new Student("홍길동", 90, 80, "컴공"),
			new Student("이순신", 95, 70, "통계"),
			new Student("김유신", 100, 60, "빅데이터")
	};
	public static void main(String[] args) {
		//3.최대, 최소 수학 점수 구하기 
		System.out.print("최대 수학 점수 : ");
		int max = maxOrMinMath((a, b) -> { //3) 2)에서 받아온 두개의 매개변수를 a, b에 담아서
			if(a>=b) return a;	//4) 두 매개변수 비교 후 둘 중 큰 값을 반환
			else return b;
		});
		System.out.println(max);
		
		System.out.print("최소 수학 점수 : ");
		int min = maxOrMinMath((a, b) -> (a<=b ? a : b));
		System.out.println(min);
		
		//5. 학생의 최대 평균, 최소 평균 점수 구하기
		System.out.print("학생 중 최대 평균 구하기 : ");
		System.out.println(maxOrMinAvg((a, b) -> a>=b ? a:b));
		
		System.out.print("학생 중 최소 평균 구하기 : ");
		System.out.println(maxOrMinAvg((a, b) -> a<=b ? a: b));
	}
	
	//2. 수학 점수 최대 최소 값 구하는 메서드
	static int maxOrMinMath(IntBinaryOperator op) {
		//1) 첫번째 math 값을 넣고
		int result = list[0].getMath();
		for(Student s : list) {
			//2) 첫번째 math 값, list를 순회하면서 math 값을 넣고
			result = op.applyAsInt(result, s.getMath());
			//5) 다시 result에 반환된 값을 넣고 list 내부의 값을 모두 순회할 때 까지 반복한다.
		}
		return result; //6) 반복이 끝난 후 최종 result 값을 반환
	}
	
	//4. 학생의 점수 최대, 최소 수학 점수 구하는 메서드
	static double maxOrMinAvg(DoubleBinaryOperator op) {
		double result = (list[0].getMath() + list[0].getEng())/2.0;
		for(Student s : list) {
			result = op.applyAsDouble(result, (s.getMath()+s.getEng())/2.0);
		}
		return result;
	}
	
	
}
