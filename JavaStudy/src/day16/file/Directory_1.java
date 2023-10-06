package day16.file;

import java.io.File;

public class Directory_1 {
	//디렉터리 확인, 생성
	public static void main(String[] args) {
		//1. 디렉터리 경로를 담은 객체 선언
		File dir = new File("E:\\Develop\\Java\\FirstJAVA\\file\\filetest");
		//2. 디렉터리 존재 확인
		System.out.println("현재 경로에 파일이 존재하니? : "+dir.exists());
		//3. 존재하면 확인 메세지 없으면 생성 후 생성 메세지
		if(dir.exists()) {
			System.out.println("디렉터리 확인");
		}else {
			dir.mkdir();
			System.out.println("디렉터리 생성");
		}
	}
}
