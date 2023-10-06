package util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

//파일 입출력 close()용 클래스
public class Closer {
	private Closer() {}
	
	public static void close(InputStream in) {
		try {
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(OutputStream out) {
		try {
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Writer w) {
		try {
			w.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Reader r) {
		try {
			r.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
