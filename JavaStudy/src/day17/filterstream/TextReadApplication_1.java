package day17.filterstream;

import java.io.*;

import util.Closer;

public class TextReadApplication_1 {
//노드 기반 스트림(바이트)으로 데이터 파일 읽기
//만든 파일 각 데이터에 맞게 형변환해서 읽어오기
	public static void main(String[] args) {
		//1. 경로, 파일 읽어올 객체 생성
		File f = new File("E:\\Develop\\Java\\FirstJAVA\\file\\customer.txt");
		FileInputStream fis = null;
		BufferedReader br = null;	
		//?????????????쓸 때는 필터 스트림 안썼는데 읽을때는 왜 쓰는거지?
		//답 : 필터 스트림 아님 파일임
		
		//2. IO 타입 checked 예외 처리
		try {
			//3. 노드, 필터 스트림 객체 생성
			fis = new FileInputStream(f);
			br = new BufferedReader(br);
			//4. 읽어 온 데이터 저장 
			String data = null;
			
			//5. 데이터 끝까지 읽어오기
			while((data = br.readLine()) != null) {
				//6. 읽어 온 데이터 구분자 기준으로 분리해서 저장
				String[] member = data.split(",");
				
				//7. 읽어온 데이터 형변환(String이 아닌 데이터는 맞는 타입으로 변환)
				int age = Integer.parseInt(member[3]);//나이는 int
				//8. 20이상인 데이터 출력
				if(age >= 20) {
					System.out.println(data);
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if(br != null) Closer.close(br);
			if(fis != null) Closer.close(fis);
		}
	}

}
