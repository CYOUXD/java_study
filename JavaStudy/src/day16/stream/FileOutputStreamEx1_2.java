package day16.stream;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

import util.Closer;

public class FileOutputStreamEx1_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("파일명을 입력하세요 : ");
		String name = scan.next();
		
		OutputStream fos = null;
		
		try {
			fos = new FileOutputStream("E:\\test\\"+name+".txt");
			System.out.print("문장 입력 : ");
			scan.nextLine();
			String str = scan.nextLine();
			
			byte[] bs = str.getBytes();
			fos.write(bs);
			System.out.println("파일이 정상적으로 저장되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();
			if(fos != null) Closer.close(fos);
		}
	}

}
