package day16.stream;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamEx2_1 {
//파일 읽어오기2	- 바이트 기반
	public static void main(String[] args) {
		//1. 읽어올 파일을 담을 빈 객체 만들기
		InputStream fis = null; //바이트 기반
		
		//2. IO 패키지기 때문에 예외 처리
		try {
			//3. 입력 스트림 객체 생성
			fis = new FileInputStream("E:\\test\\test.txt"); //읽어올 파일 위치
			
			//4. 읽어올 데이터를 저장할 공간 만들기
			byte[] buffer = new byte[256];
			
			//5. 배열의 크기만큼 읽어온 데이터를 변수에 담기
			int readCont = fis.read(buffer);	//256byte 만큼 읽어옴
			
			//6. 나머지 데이터 전부 읽어오기
			while(readCont != -1) { //읽을게 있다면
				//7. 데이터를 읽어와서 String으로 바꿔서 출력용 변수에 저장
				String data = new String(buffer, 0, readCont); 
				//while 밖에서 처음으로 읽은거 집어넣어야 하니까 먼저 선언
				//8. 데이터 출력
				System.out.println(data); //while 밖에서 처음으로 읽은거도 출력해야하니까 먼저 선언
				//9. 그 다음 블럭을 읽어와서 buffer에 저장하고 읽은 데이터의 수를 반환 = 다음 블럭 유무 반환
				readCont = fis.read(buffer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {fis.close();} catch (Exception e2) {e2.printStackTrace();}
		}
	}

}
