package day16.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamEx1_1 {
//파일 읽어오기1	- 바이트 기반
	public static void main(String[] args) {
		//1. 읽어올 파일을 담을 객체 생성
		InputStream fis = null; //바이트 기반
		
		//2. IO 패키지기 때문에 예외 처리
		try {
			//3. 입력 스트림 객체 생성
			fis = new FileInputStream("E:\\test\\test.txt");
			
			//4. 읽어온 데이터를 저장할 공간 만들기. 
			//read가 fis를 읽어와서 buffer에 데이터를 1000 byte씩 저장
			byte[] buffer = new byte[1000];	// 1000byte 씩 읽어와서 buffer[]에 저장한다.
			
			//5. 읽어온 데이터 배열의 내용을 쌓아서 출력할 변수 만들기
			String content = "";
			
			//6. 정해진 크기 만큼씩 끝까지 반복해서 읽어오기
			while(true) {
				//7. 읽어올 데이터가 담긴 배열의 크기 알아오기
				int data = fis.read(buffer);
				//InputStream의 read()는 fis로 부터 읽은 byte 데이터를 매개변수(buffer)배열에 저장하고 실제로 읽은 바이트의 수를 반환한다.
				//더 이상 읽을 데이터가 없다면 -1을 반환한다.
				//(한글의 경우 2byte이기 때문에 1byte만 읽어온다면 절반만 읽어와서 깨져보인다.)
				
				
				//8. 읽을 데이터가 있다면 그 데이터를 출력용 변수에 담아준다
				if(data != -1) content = new String(buffer, 0, data);
				//String(buffer, 0, data) : buffer 내부 인덱스 0 ~ data 까지 String으로 반환
				
				//10. 더 이상 읽을 데이터가 없다면 종료
				else break;
				
				//9. 담은 데이터 출력하기
				System.out.println(content);	
				//????? while 안에서 출력하는거랑 밖에서하는거랑 차이가 있나? 밖에서 하면 마지막 한 줄만 나오나?
				//답 : 
			}
		//11. 읽을 파일을 못 찾았을 경우
		} catch (FileNotFoundException fe) {
			System.out.println("해당 경로의 파일을 찾을 수 없습니다.");
		//12. 파일을 읽을 수 없는 경우
		} catch (IOException e) {
			System.out.println("파일을 읽을 수 없습니다.");
			//오류시 띄워줄 문구를 넣어줬으니 printStackTrace()는 없어도 됨
		} finally {
			//13. fis를 닫을 때 생기는 예외 처리
			try {fis.close();} catch (Exception e2) {e2.printStackTrace();}
		}
	}

}
