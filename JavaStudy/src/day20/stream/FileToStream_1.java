package day20.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileToStream_1 {
//파일 읽어들이기 
	public static void main(String[] args) {
		//1. 예외 처리 - 파일 입출력이니까
		try {
			//2. Paths.get() 메서드 사용
			Path path = Paths.get("src/day20/stream/StrToStream_1.java");
			//Path 클래스 : 파일을 찾을 때 사용하는 객체. 파일 경로를 나타냄
			//Paths : 경로를 변환하여 Path 클래스를 반환
			//Stream 객체 만들기
			Stream<String> stream = Files.lines(path, Charset.defaultCharset());
			//Files.lines모두 읽어오기(path파일에서, Charset.defaultCharset()기본 인코딩 타입으로)
			stream.forEach(s -> System.out.println(s));
			stream.close();
			System.out.println();
			
			//3. BufferedReader의 lines 메서드 사용
			//파일 객체 만들기
			File file = path.toFile(); //toFile : 앞의 경로를 파일로 객체로 변환
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			br.lines().forEach(s -> System.out.println(s));
			//lines() : 반환 타입이 Stream<string>이기 때문에 forEach 사용 가능
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} //finally에서 할 close를 위에서 했기 때문에 finally는 안써줌
	}

}
