package day17.filterstream;

import java.io.*;

import util.Closer;

public class BufferedReadWriteEx2_1 {
//작성한 텍스트를 필터 스트림으로 저장하고 읽어오기(별도 메서드로 만들어서 사용)
	public static void main(String[] args) {
		//1. 저장할 텍스트 작성
		String htmlCode = "<html><head><style>\n";
		htmlCode += "div { \n"
				+"		width: 100px; \n"
				+"		height: 100px; \n"
				+"		color: white; \n"
				+"		background: red; \n"
				+"		padding: 50px; \n"
				+"		font-size : 30px; \n"
				+" }\n";
		htmlCode += "</style></head><body>";
		htmlCode += "<div>Hello HTML!</div>";
		htmlCode += "</body></html>";
		
		//2. 만들 파일 경로 저장하기
		String path = "E:\\Develop\\Java\\FirstJAVA\\file\\index.html";
		
		write(path, htmlCode);
		
		read(path);
		
	}
	//3. write() 만들기
	public static void write(String path, String code) {
		//4. 경로, 쓰기 노드 스트림, 쓰기 필터 스트림 객체 선언
		File f = new File(path);
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		//5. IO 타입 checked 예외 처리
		try {
			//?????????????????????????????? 왜 객체 생성과 선언을 나눠서 하나요? 둘 다 여기서 하면 안됨?
			//답 : try 밖에서 생성해야 finally에서 close()해 줄 수 있다. 
			//6. 객체 생성하기
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			
			//7. 파일 만들고 쓰기
			bw.write(code);			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null) Closer.close(bw);
			if(fw != null) Closer.close(fw);
		}
	}
	
	//8. read() 만들기
	public static String read(String path) {
		//9. 경로, 읽기 노드 스트림, 읽기 필터 스트림 객체 생성
		File f = new File(path);
		FileReader fr = null;
		BufferedReader br = null;
		
		//10. 읽어 온 데이터 저장할 곳 만들기
		String code = null;
		
		//11. IO 타입 checked 예외 처리
		try {
			//12. 객체 선언
			code = new String();		
			//?????????????? 그냥 String code랑 객체 선언한 code랑 뭐가 다르지? String의 메서드를 쓸 수 있다는거? return해서 출력해야 되니까???
			//답 : String 객체 생성을 해야 readLine으로 읽은 값을 쌓아서 return할 수 있음 
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			//13. 데이터를 끝까지 반복해서 읽고 저장
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
				code += line;
			}			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) Closer.close(br);
			if(fr != null) Closer.close(fr);
		}
		
		return code;
	}

}
