package day21.thread;

import java.io.IOException;

public class ProcessEx_1 {
//자바에서 다른 프로그램 실행하기
	public static void main(String[] args) {
		//1. Runtime = Checked Exception
		try {
			//2. 메모장 실행하기
			Process p1 = Runtime.getRuntime().exec("notepad.exe");
			//Runtime : 운영체제 프로그램과의 상호 작용 가능.운영체제 기반 프로그램 실행 혹은 정보 제공
			//getRuntime().exec(프로그램 or 명령어) : (프로그램 or 명령어)를 실행시키고 해당 프로세스의 레퍼런스를 반환
			System.out.println(p1.pid()); //pid() : 프로세스 아이디
			
//			p1.waitFor(); //p1이 종료 된 후 p2 실행
			
			//3. 그림판 실행
			Process p2 = Runtime.getRuntime().exec("mspaint.exe");
			
			p1.waitFor(); 
			p2.destroy(); //p1, p2 실행 되고 p1이 종료되길 기다린 후 p2 종료
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
