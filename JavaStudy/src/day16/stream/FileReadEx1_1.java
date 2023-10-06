package day16.stream;

import java.io.File;
import java.io.FileReader;

public class FileReadEx1_1 {
	//파일 읽어오기 - 문자 기반
	public static void main(String[] args) {
		//1. 읽어올 파일 경로 객체 생성
		File f = new File("E:\\Develop\\Java\\FirstJAVA\\file\\w.txt");
		
		//2. 읽어올 파일 담을 객체 생성
		FileReader in = null;
		
		//3. IO 패키지기 때문에 예외 처리
		try {
			//4. 일어올 파일 객체 선언
			in = new FileReader(f);	//읽어올 파일 위치 f
			//5. 전체 문자를 다 읽을 때까지 반복
			while(true) {
				//6. 읽어온 문자를 변수에 담기
				int data = in.read();
				//문자 기반의 read()는 char이나 -1를 반환한다. 2byte씩 읽어온다.
				//char는 숫자로 변환이 가능하니 int에 넣을 수 있다.
				//7. 2byte씩 읽어온 데이터 출력하기
				System.out.print((char)data);	//char로 바꿔서 출력한다.
				//8. 더 이상 읽어올 데이터가 없다면 정지
				if(data == -1) {
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {in.close();} catch (Exception e2) {e2.printStackTrace();}
		}
	}

}
