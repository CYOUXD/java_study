package day17.filterstream;

import java.io.*;

//char 타입 데이터 필터 스트림으로 읽고, 복사하고, 붙여 넣은 새 파일 만들기
public class FilterStreamExample_1 {

	public static void main(String[] args) {
		//1. 버퍼링 Char 타입 필터 스트림 객체 만들기
		//필터 스트림은 노드 스트림을 사용해 기능을 강화하기 때문에 노드 스트림도 함께 사용한다.
		FileReader input = null;
		FileWriter output = null;
		BufferedReader bufInput = null;
		BufferedWriter bufOutput = null;
		//BufferedWriter는 close()하기 전까지 파일이 생성되지 않는다.
		
		//2. IO 타입 checked 예외 처리
		try {
			//3. 파일 경로 저장
			//읽어올 파일
			String inFile = "E:\\Develop\\Java\\FirstJAVA\\file\\OutputStream.txt";
			//만들 파일
			String outFile = "E:\\Develop\\Java\\FirstJAVA\\file\\OutputStream_out.txt";
			
			//노드 스트림 객체 생성
			input = new FileReader(inFile);
			output = new FileWriter(outFile);
			//필터 스트림 객체 생성
			bufInput = new BufferedReader(input);
			bufOutput = new BufferedWriter(output);
			
			//4. 읽어 온 char 데이터를 저장할 객체 생성
			String line;
			line = bufInput.readLine();
			//readLine() : 문자열에서 \n을 만날 때까지 입력. 읽을 데이터가 없으면 null 반환
			System.out.println(line);
			
			//5. 데이터를 전부 읽어 와서 붙여 넣기
			while(line != null) {//= 데이터를 전부 읽어 올 때까지 반복
				bufOutput.write(line, 0, line.length());	//line 복사 후 쓰기
				bufOutput.newLine();// = 줄바꿈 = \n
				line = bufInput.readLine();	//다음 줄 읽어오기
			}
			System.out.println(inFile+" >> "+outFile);//복사 붙여넣기
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//bufOutput이 null이 아니라면 bufOutput을 닫는다. + 예외 처리
			if(bufOutput != null)
				try {bufOutput.close();} catch (Exception e) {e.printStackTrace();}
			//bufInput이 null이 아니라면 bufInput을 닫는다. + 예외 처리
			if(bufInput != null)
				try {bufInput.close();} catch (Exception e) {e.printStackTrace();}
		}
		
	}

}
