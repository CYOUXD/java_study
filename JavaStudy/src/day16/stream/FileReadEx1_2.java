package day16.stream;

import java.io.File;
import java.io.FileReader;

import util.Closer;

public class FileReadEx1_2 {

	public static void main(String[] args) {
		File f = new File("E:\\Develop\\Java\\FirstJAVA\\file\\w.txt");
		
		FileReader in = null;
		try {
			in = new FileReader(f);
			while(true) {
				int data = in.read();
				System.out.print((char)data);
				if(data == -1) break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) Closer.close(in);
		}
	}

}
