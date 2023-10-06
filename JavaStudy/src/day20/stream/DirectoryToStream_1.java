package day20.stream;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class DirectoryToStream_1 {
// list(), find() 메서드를 이용하여 스트림 생성하기
	public static void main(String[] args) {
		//1. 예외처리 - 디렉터리 명을 읽어올거라 예외처리 필요
		try {
			//2. list() 메서드로 스트림 생성
			System.out.println("list() 메서드를 이용하여 스트림 생성하기");
			
			//src 디렉터리로 Path 객체 생성
			Path path = Paths.get("src"); //실행 위치 안에 있는 src 디렉터리를 의미함
			//?????????? Paths.get("src") src 내부에 있는 모든 디렉터리와 파일을 Path객체로 생성하는건가???
			//답 : File의 get이랑 Paths의 get이랑 기능이 조금 다름. Paths의 get에서 디렉터리 명을 사용하면 그 내부에 있는 모든 디렉터리와 파일을 객체로 집어 넣게 됨 
			
			//src 경로의 모든 디렉터리와 파일 Stream 객체로 생성
			Stream<Path> sr1 = Files.list(path);
			sr1.forEach(p -> System.out.println(p.getFileName()));
			
			//3. find() 메서드로 스트림 생성
			System.out.println("find() 메서드를 이용해서 스트림 생성하기");
			Stream<Path> sr2 = Files.find(path, 10, (p, BasicFileAttributes) -> {//(4)Stream<Path> 객체를 생성한다.
//			(1)Stream<Path> sr2 = Files.find(path부터 시작해서, 10의 깊이까지의 파일을, (p에 담아서, BasicFileAttributes 각p의 속성값으로)
				File file = p.toFile(); //(2)파일 객체를 만들고
				return !file.isDirectory() && file.getName().contains("Stream");
				//(3)만든 객체가 디렉터리가 아니고, 파일 이름에 Stream이 포함된 파일명만 반환해서
			});
			
			sr2.forEach(p -> System.out.println(p.getFileName()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
