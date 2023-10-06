package day16.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import util.Closer;

public class FileInputStreamEx1_2 {

	public static void main(String[] args) {
		InputStream fis = null;
		
		try {
			fis = new FileInputStream("E:\\test\\test.txt");
			
			byte[] buffer = new byte[1000];
			String content = "";
			
			while(true) {
				int dataLength = fis.read(buffer);
				if(dataLength != -1) content = new String(buffer, 0, dataLength);
				else break;
				System.out.println(content);
			}			
			
		} catch (FileNotFoundException e) {
			System.out.println("해당 경로의 파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("파일을 읽을 수 없습니다.");
		} finally {
			if(fis != null) Closer.close(fis);
		}
	}

}
