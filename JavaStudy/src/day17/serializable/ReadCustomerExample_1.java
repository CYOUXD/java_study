package day17.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import util.Closer;

public class ReadCustomerExample_1 {
	//객체 역직렬화
	//객체로 만들어진 파일 읽어오기
	public static void main(String[] args) {
		//1. 읽어올 파일 객체 만들기
		File file = new File("E:\\Develop\\Java\\FirstJAVA\\file\\customer.ser");
		
		//2. byte 기반 데이터 출력 객체 선언
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		//3. 예외처리
		try {
			//4. 객체 생성
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			//5. 읽어 온 데이터 객체로 저장
			Customer_1 cus1 = (Customer_1)ois.readObject();
			Customer_1 cus2 = (Customer_1)ois.readObject();
			//????????? 알아서 객체 별로 읽어 오나??
			//답 : 
			
			//6. 리스트로 저장된 데이터 역직렬화
			@SuppressWarnings("unchecked") //아래 ArrayList 경고 뜬걸 알고 있다는 의미
			ArrayList<Customer_1> list = (ArrayList<Customer_1>)ois.readObject();
			
			//7. 출력
			System.out.println(cus1);
			System.out.println(cus2);
			System.out.println(list);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(ois != null) Closer.close(ois);
			if(fis != null) Closer.close(fis);
		}
	}

}
