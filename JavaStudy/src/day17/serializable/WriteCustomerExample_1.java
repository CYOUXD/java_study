package day17.serializable;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import util.Closer;

public class WriteCustomerExample_1 {
	//객체 직렬화
	//객체로 만든 데이터를 list에 넣고 파일로 저장
	public static void main(String[] args) {
		//1. 데이터를 가진 객체 생성
		Customer_1 cus1 = new Customer_1("홍길동", 'M', "abc@naver.com", 30);
		Customer_1 cus2 = new Customer_1("홍동동", 'W', "123@naver.com", 30);
		
		//2. 파일 객체 생성
		File file = new File("E:\\Develop\\Java\\FirstJAVA\\file\\customer.ser");
		
		//3. byte 기반 데이터 입력 객체 선언
		FileOutputStream fos = null;
		ObjectOutputStream oos = null; 
		//serializable은 ObjectOutputStream을 사용
		
		//4. 예외처리
		try {
			//5. 객체 생성
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			//6. 객체를 직렬화하여 파일에 저장
			oos.writeObject(cus1);
			oos.writeObject(cus2);
			
			//7. 리스트에 객체 저장
			ArrayList<Customer_1> list = new ArrayList<>();
			list.add(cus1);
			list.add(cus2);
			oos.writeObject(list);
			//???????????????????????? 특수 문자가 깨져서 보인다. 왜지?
			//답 : 
			
			//System.out.println(list.toString());
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(oos != null) Closer.close(oos);
			if(fos != null) Closer.close(fos);
		}
	}

}
