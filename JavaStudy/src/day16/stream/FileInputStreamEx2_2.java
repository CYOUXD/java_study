package day16.stream;

import java.io.FileInputStream;
import java.io.InputStream;

import util.Closer;

public class FileInputStreamEx2_2 {

	public static void main(String[] args) {
		InputStream fis = null;
		
		try {
			fis = new FileInputStream("E:\\test\\test.txt");
			byte[] buffer = new byte[256];
			int readCount = fis.read(buffer);
			while(readCount != -1) {
				String data = new String(buffer, 0, readCount);
				System.out.println(data);
				readCount = fis.read(buffer);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fis != null) Closer.close(fis);
		}
		
	}

}
