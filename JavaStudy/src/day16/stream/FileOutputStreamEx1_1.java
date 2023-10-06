package day16.stream;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class FileOutputStreamEx1_1 {
//문자열을 입력 받고 해당 문자열을 파일로 만들어서 쓰기 -바이트 기반
	public static void main(String[] args) {
		//1. 파일명 입력 받기
		Scanner scan = new Scanner(System.in);
		System.out.println("파일명을 입력하세요");
		String name = scan.next();
		
		//2. 빈 객체 만들기
		OutputStream fos = null;  //바이트 기반
		//OutputStream : 바이트 기반 출력 스트림의 최상위 클래스. 추상 클래스이므로 직접 객체 생성이 안되고 하위 객체로 생성한다.
		
		//3. IO 패키지기 때문에 예외 처리
		try {
			//4. 만든 객체에 파일을 생성하기
			fos = new FileOutputStream("E:\\test\\"+name+".txt");
			//OutputStream 객체는 하위객체로 선언한다.
			
			//5. 파일에 넣을 문장 입력 받기
			System.out.println("문장 입력 : ");
			scan.nextLine(); //버퍼 비우기
			//첫번째 scan에서 엔터친 것이 다음 scan에 들어간걸로 인식되기 때문에 오류가 난다. 버퍼를 비워서 해결!
			String str = scan.nextLine();
			
			//6. 받아온 문장을 byte 배열로 바꾼다. 
			byte[] bs = str.getBytes(); //getBytes() : char -> byte
			//getBytes : String을 byte 배열로반환
			//OutputStream은 byte 기반이므로 해당 객체에 넣으려면 byte배열 이어야 한다.
			
			//7. 파일에 받아온 문장을 써준다.
			fos.write(bs);
			System.out.println("파일이 정상적으로 저장되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {fos.close();scan.close();} catch (Exception e2) {e2.printStackTrace();}
		}
		
	}

}
