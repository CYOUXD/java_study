package day22.network;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class URLEx_1 {
//URL 클래스 - 인터넷에 접근할 수 있는 형태를 분석하는 클래스. 인터넷을 통해 서버에 접근할 때 사용
	public static void main(String[] args) {
		//1. 예외처리
		try {
			//2. URL 객체 생성
			URL url = null;
			url = new URL("https://www.egovframe.go.kr/EgovIntro.jsp?menu=1&submenu=1");
			
			//3. getAuthority() - 호스트명과 포트 리턴
			System.out.println("getAuthority : "+url.getAuthority());
			//?????? 호스트 명 밖에 안나오는데?
			
			//4. getContent() - content 객체 리턴
			//??????? content가 뭐지?
			System.out.println("getContent : "+url.getContent());
			
			//5. getProtocol() - URL 프로토콜 리턴
			System.out.println("getProtocol : "+url.getProtocol());
			
			//6. getHost() - 호스트명 리턴(DNS)
			System.out.println("getHost : "+url.getHost());
			
			//7. getPort() - 포트 리턴
			System.out.println("getPort : "+url.getPort());
			
			//8. getPath() - 경로명 리턴
			System.out.println("getPath : "+url.getPath());
			
			//9. getFile() - 파일명 리턴
			System.out.println("getFile : "+url.getFile());
			
			//10. getQuery() - 쿼리 리턴
			System.out.println("getQuery : "+url.getQuery());
			
			
			//11. URL을 통해 정보 받기
			int data = 0;
			try {
				//openStream() - URL과 연결된 객체의 InputStream 리턴
				Reader is = new InputStreamReader(url.openStream());
				while((data = is.read()) != -1) { //-1 : 더 이상 데이터가 없음
					System.out.print((char)data);
				}
				System.out.println();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
