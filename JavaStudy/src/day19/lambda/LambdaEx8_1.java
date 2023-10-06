package day19.lambda;

import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public class LambdaEx8_1 {
//Function 인터페이스 람다식 (매개변수O, 반환값O)
	//2. 학생 정보 리스트 담기
	static Student[] list = {
			new Student("홍길동", 90, 80, "컴공"),
			new Student("이순신", 95, 70, "통계")
	};
	public static void main(String[] args) {
		//3. 전체 학생명 출력
		System.out.print("전체 학생명 : ");
		printString(t -> t.getName());
		//4. 전체 전공 출력
		System.out.print("전체 전공명 : ");
		printString(t -> t.getMajor());
		
		//5. 전체 영어 점수 출력
		System.out.print("전체 영어 점수 : ");
		printInt(t -> t.getEng());
		//6. 전체 수학 점수 출력
		System.out.print("전체 영어 점수 : ");
		printInt(t -> t.getMath());
		//7. 영어 점수 합계 출력
		System.out.print("영어 점수 합계 : ");
		printTot(t -> t.getEng());
		//8. 수학 점수 합계 출력
		System.out.print("영어 점수 합계 : ");
		printTot(t -> t.getMath());
		
		//9. 영어 점수 평균 출력
		System.out.print("영어 점수 평균 : ");
		printAvg(t -> t.getEng());
		//10. 수학 점수 평균 출력
		System.out.print("수학 점수 평균 : ");
		printAvg(t -> t.getMath());
	}
	
	//3. 전체 학생명 출력, 전체 전공 출력
	static void printString(Function<Student, String> f) {
		for(Student s : list) {
			System.out.print(f.apply(s)+" ");
		}
		System.out.println();
	}
	
	//5. 전체 영어 점수 출력, 전체 수학 점수 출력
	static void printInt(Function<Student, Integer> f) {
		for(Student s : list) {
			System.out.print(f.apply(s)+" ");
		}
		System.out.println();
	}
	
	//7. 영어 점수 합계 출력, 수학 점수 합계 출력
	static void printTot(ToIntFunction<Student> f) {
		int sum = 0;
		for(Student s : list) {
			sum += f.applyAsInt(s);
		}
		System.out.println(sum);
	}
	
	//9. 영어 점수 평균 출력, 수학 점수 평균 출력
	static void printAvg(ToDoubleFunction<Student> f) {
		double sum = 0;
		for(Student s : list) {
			sum += f.applyAsDouble(s);
		}
		System.out.println(sum/list.length);
	}
}

//1. 학생 정보를 담을 클래스 생성
class Student{
	private String name;
	private int eng;
	private int math;
	private String major;
	public Student(String name, int eng, int math, String major) {
		super();
		this.name = name;
		this.eng = eng;
		this.math = math;
		this.major = major;
	}
	public String getName() {
		return name;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public String getMajor() {
		return major;
	}
	
}