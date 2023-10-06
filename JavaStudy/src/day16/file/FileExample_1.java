package day16.file;

import java.io.File;

public class FileExample_1 {

	//환경 변수 생성
	static String env_path = "C:\\Program Files\\Common Files\\Oracle\\Java\\javapath;C:\\Windows\\system32;C:\\Windows;C:\\Windows\\System32\\Wbem;C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\;C:\\Windows\\System32\\OpenSSH\\;%JAVA_HOME%\\bin;C:\\Program Files\\Bandizip\\;C:\\Users\\tjoeun\\AppData\\Local\\Microsoft\\WindowsApps;"; 
	
	public static void main(String[] args) {
		//파일의 경로(존재 유무 상관X 없으면 만들면 됨)
		File f = new File("E:/Develop/Java/FirstJAVA/file/filetest/a.txt");
		//디렉터리 경로
		File dir = new File("./"); // ./ : 현재 디렉터리, ../ : 부모 디렉터리
		
		//1. exists : 파일 혹은 디렉터리 유무 확인
		System.out.println("exist? : "+f.exists());
		System.out.println("exist? : "+dir.exists());
		
		//2. isDirectory : 디렉터리인지 여부 확인(파일이라면 false)
		System.out.println("isDirectory? : "+f.isDirectory());
		System.out.println("isDirectory? : "+dir.isDirectory());
		
		//3. isAbsolute : 해당 경로가 절대 경로인지 확인
		System.out.println("isAbsolute? : "+f.isAbsolute());
		System.out.println("isAbsolute? : "+dir.isAbsolute());
		
		//4. canExecute, canRead, canWrite : 권한 확인
		System.out.println("canExcute? : "+f.canExecute());
		System.out.println("canExcute? : "+dir.canExecute());
		System.out.println("canRead? : "+f.canRead());
		System.out.println("canRead? : "+dir.canRead());
		System.out.println("canWrite? : "+f.canWrite());
		System.out.println("canWrite? : "+dir.canWrite());
		
		//5. getAbsolutePath : 절대 경로 반환(상대 경로의 절대 경로를 반환)
		System.out.println("./의 실제 위치(절대 경로) : "+dir.getAbsolutePath());
		
		//6. getParent : 부모 폴더를 문자열로 반환
		System.out.println(f.getParent());
		
		//7. getParentFile : 부모 폴더를 file 객체로 반환
		File f_parent = f.getParentFile();
		System.out.println(f_parent);
		
		//8. static한 것들(File 객체의 상수)
		System.out.println(File.separator);				// "\"	- File의 경로를 구분값
		System.out.println(File.separatorChar);			// "\"
		System.out.println(File.pathSeparator);			// ";"	- 경로가 여러개 연속으로 붙어 있을 때 구분값
		System.out.println(File.pathSeparatorChar);		// ";"
	
		//9. 환경 변수
		String[] path = env_path.split(File.pathSeparator);
		for(String p : path) {
			System.out.println(p);
		}
		
		//10. 파일 생성, 수정, 삭제 메서드
		File test = new File("D:\\filetest3\\temp\\abc");
		//mkdir() : 해당 경로에 폴더를 생성(디렉터리 생성)
		//mkdirs() : 존재하지 않는 부모 폴더까지 모두 포함해서 폴더를 생성
		if(!test.exists()) {
//			test.mkdir();		//D:\\filetest3\\temp 디렉터리에 abc를 만든다
			test.mkdirs();		//전부 다 만들기
		}
		
		//11. createNewFile : 파일이 없으면 생성
		test = new File("D:\\filetest3\\temp\\abc\\a.txt");
		try {
			test.createNewFile();
		} catch (Exception e) {
			System.out.println("파일 생성 중 에러가 발생하면 나오는 메세지!");
		}
		
		//12. delete : 파일이나 폴더를 삭제한다. 폴더는 비어 있지 않으면 삭제할 수 없다.
		test = new File("D:\\filetest3\\temp\\abc\\a.txt");
		test.delete();
		
		//13. renameTo : 파일이나 폴더의 이름 및 경로를 변경
		test = new File("D:\\filetest3\\temp");
		File dst = new File("D:\\filetest3\\temp2");
		test.renameTo(dst);
		
	}

}
