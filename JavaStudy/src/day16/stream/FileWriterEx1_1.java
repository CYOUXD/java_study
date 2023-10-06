package day16.stream;

import java.io.File;
import java.io.FileWriter;

public class FileWriterEx1_1 {
	//파일 내용 쓰기
	public static void main(String[] args) { //문자 기반
		//1. 내용을 쓸 파일의 정보를 담은 객체 생성
		File f = new File("E:\\Develop\\Java\\FirstJAVA\\file\\w.txt");
		
		//2. 파일 쓰기 객체 선언
		FileWriter out = null;
		
		//3. IO 패키지기 때문에 예외 처리
		try {
			//4. 파일 쓰기 객체 생성
			out = new FileWriter(f, true); //true:추가, false:덮어쓰기
			//5. 내용 쓰기
			out.append("테스트용 메세지1!!!\n");	//기본 줄바꿈 없음
			out.append("테스트용 메세지2!!!\n");
			out.write("write로 쓴 메세지!!!");
			out.append("테스트용 메세지3!!!");
		} catch (Exception e) {
			//5.5 append하는 과정에서 오류가 날 때 실행
			e.printStackTrace();
		} finally {
			//???????????????? 위에서 오류 체크 했는데 왜 아래서 또 하는거지???????
			//답 : out을 close로 닫았을 때 오류가 날 수도 있으니 예외처리 하는 것
			//6. out을 닫을 때 실행 할 예외 처리
			if(out != null)
				try {out.close();} catch (Exception e2) {e2.printStackTrace();}
		}
	}

}
