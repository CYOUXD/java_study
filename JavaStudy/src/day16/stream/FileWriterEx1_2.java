package day16.stream;

import java.io.File;
import java.io.FileWriter;

import util.Closer;

public class FileWriterEx1_2 {

	public static void main(String[] args) {
		File f = new File("E:\\Develop\\Java\\FirstJAVA\\file\\w.txt");
		FileWriter out = null;
		
		try {
			out = new FileWriter(f, true);
			out.append("테스트용 문장 추가1 123 abc");
			out.append("테스트용 문장 추가2 123 abc");
			out.write("테스트용 문장 추가3 123 abc");
			out.append("테스트용 문장 추가4 123 abc");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(out != null) Closer.close(out);
		}
	}

}
