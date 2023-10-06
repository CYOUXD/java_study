package day17.filterstream;

import java.io.File;
import java.io.FileOutputStream;

import util.Closer;

public class TextWriterApplication_1 {
//데이터 잘라서 형 변환하고 파일 쓰고 만들기 - 단순 텍스트 사용
//구분자를 이용한 문자열 분리, 데이터 형 변환 필수
//노드 기반 스트림(바이트)
//?????????????????????????????????단순 텍스트만 있는데 왜 char를 사용하지 않았지??	
//답 : 바이트 단위로 저장할 거라서
	public static void main(String[] args) {
		//1. 저장할 단순 데이터 입력
		String data1 = "홍길동,M,hkd@test.com,30"; //"," 로 필드(데이터) 구분자
		//데이터 사이에서 값과 값을 구분하는 레코드 구분자(\n) = 컬럼 구분자
		String data2 = "홍길남,M,hkn@test.com,25"; 
		
		//2. 경로, 파일 입력 객체 생성(바이트)
		File f = new File("E:\\Develop\\Java\\FirstJAVA\\file\\"+"customer.txt");
		FileOutputStream fos = null;
		
		//3. IO 타입 checked 예외 처리
		try {
			//4. 입력 객체 선언, 데이터 형변환 후 저장
			fos = new FileOutputStream(f);
			fos.write(data1.getBytes()); //getBytes() : 유니코드 문자열을 byte로 변환
			fos.write('\n');//레코드 구분자, 데이터 구분자
			fos.write(data2.getBytes());
			fos.write('\n');
			System.out.println("File saved!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fos != null) Closer.close(fos);
		}	
		
	}

}
