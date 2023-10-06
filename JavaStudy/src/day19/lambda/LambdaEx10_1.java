package day19.lambda;

import java.util.function.Predicate;

public class LambdaEx10_1 {
//Predicate 매개변수O, 반환타입O boolean
//boolean 값으로 특정 조건 값 확인 후 실행
	//1. 학생 정보를 리스트에 담기
	static Student[] list = {
			new Student("홍길동", 90, 80, "컴공"),
			new Student("이순신", 95, 70, "통계"),
			new Student("김유신", 100, 60, "컴공")
	};
	public static void main(String[] args) {
		//3. 과가 컴공인 학생의 영어 점수 평균
		double avg = aveEng(t -> t.getMajor().equals("컴공"));
		//?????????? 아래의 추상메서드 test를 구현한게 이 람다식인가??
		//답 : 
		System.out.println("컴공과 영어 평균 점수 : "+avg);
		
		//5. 과가 컴공인 학생의 수학 점수 평균
		double avg2 = aveMath(t -> t.getMajor().equals("컴공"));
		System.out.println("컴공과 수학 평균 점수 : "+avg2);
	}

	//2. 컴공과 학생의 영어 점수 평균 구하는 메서드
	private static double aveEng(Predicate<Student> predicate) {
		int count = 0; //학생 수
		int sum = 0; //총 점수
		for(Student student : list) {
			if(predicate.test(student)) { //test : predicate의 추상 메서드
				count++;
				sum += student.getEng();
			}
		}
		return (double)sum/count;
	}
	
	//4. 컴공과 학생의 수학 점수 평균 구하는 메서드
	private static double aveMath(Predicate<Student> predicate) {
		int count = 0;
		int sum = 0;
		for(Student student : list) {
			if(predicate.test(student)) {
				count++;
				sum+=student.getMath();
			}
		}
		return (double)sum/count;
	}
}