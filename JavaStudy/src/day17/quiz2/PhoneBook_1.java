package day17.quiz2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import util.Closer;

public class PhoneBook_1 {

	// HashMap을 이용해 전화번호부를 구현해 보세요
	
	// 1. "그룹/전화번호/이름'을 저장해야 합니다.
	// 2. 그룹을 키값으로 넣으면 그 그룹에 해당하는 HashMap이 선택됩니다. 
	// 3. 그룹의 HashMap에 전화번호를 키값으로 넣으면 이름이 나온다
	
	// ####메서드####
	// 1. phoneBook에 새로운 그룹을 추가하는 메서드
	// 2. phoneBook의 모든 목록을 한번에 출력해주는 메서드
	// 3. 이미 존재하는 그룹에 전화번호를 추가하는 메서드(그룹이 없으면 추가 못함)
	//    (> 모든 전화번호를 HashSet형태로 반환 및 중복 체크 기능도 있어야 함)
	// 4. 전화번호의 일부를 입력하면 입력한 부분과 일치하는 모든 사람의 목록을 출력하는 메서드
	// 5. 이름을 입력하면 해당하는 사람의 전화번호를 모두 출력하는 메서드(동명이인이 있는 경우 여러개 출력)
	// *** 변경된 내용이 파일에 저장되어 프로그램을 다시 실행할 때도 유지되도록 만들어 주세요.!!!

	
	//1. HashMap 선언 하기
	HashMap<String, HashMap<String, String>> phoneBook;
	
	//9-2. 파일 객체, 경로 만들기
	File saveFile = null;
	String savePath = "savefile/phonebook.sav";
	//??????????? 경로를 이렇게만 만들면 더 앞쪽은 어떻게 설정하지?
	
	//2. 객체 생성 - 생성자 선언과 함께 객체 생성할 것 작성
	public PhoneBook_1() {
		phoneBook = new HashMap<>();
		
		//9-3. 생성자 선언시 저장된 파일로 객체 생성
		saveFile = new File(savePath);
		//9-4. 생성자 선언시 저장된 파일이 없다면 앞으로 만들 파일을 저장할 디렉터리 생성
		if(!saveFile.exists()) {
			File dir = new File(saveFile.getParent());
			dir.mkdirs();
		}
		//10-2. 객체 생성시 이미 파일이 있다면 데이터 읽어오기
		load();
	}
	
	//3. phoneBook에 새로운 그룹을 추가하는 메서드
	public void addGroup(String groupNames) {
		//그룹명 중복 확인
		if(!phoneBook.containsKey(groupNames)) {
			//그룹명만 넣고 value는 장소만 만들어 줌
			phoneBook.put(groupNames, new HashMap<String, String>());
		}
	}
	
	//4. phoneBook의 모든 목록을 출력
	public void printAll() {
		//출력할 HashMap의 키를 가져와서 각 키와 value를 출력
		Set<String> groupNames = phoneBook.keySet();
		for(String groupName : groupNames) {
			//그룹명 출력
			System.out.println("* * * * *"+groupName+"* * * * *");
			
			//이름, 전화번호 출력
			HashMap<String, String> nameAndNums = phoneBook.get(groupName);
			//데이터 유무 확인
			if(nameAndNums.size() == 0) {	//데이터가 없을 때
				System.out.println("비어 있음");
			}else {
				for(String number : nameAndNums.keySet()) {// key값 = number
					//키 값은 전화번호지만 이름 먼저 출력
					System.out.printf("%s : %s\n", nameAndNums.get(number), number);
				}
			}
		}
	}
	
	//6-1. 이미 존재하는 그룹에 전화번호를 추가하는 메서드(그룹이 없으면 추가 못함)
	//모든 전화번호를 HashSet형태로 반환 및 중복 체크 기능 추가
	public AddphMessage addPhoneNo(String groupName, String number, String name) {
		if(!phoneBook.containsKey(groupName)) {
			return new AddphMessage("없는 그룹입니다.", AddphMessage.NOT_EXISTING_GROUP);
		}else {
			HashMap<String, String> numberAndNames = phoneBook.get(groupName);
			
			//6-4. 전화번호 중복 체크
			if(checkDupleNumber(number)) {
				return new AddphMessage("이미 등록된 번호입니다. 수정하시겠습니까?", AddphMessage.EXISTING_NUMBER);
			}
			
			numberAndNames.put(number, name);
			return new AddphMessage("정상적으로 등록되었습니다.", AddphMessage.ADD_SUCCESS);
			
		}
	}
	
	//6-2. 모든 전화번호 불러오기
	private Set<String> getAllNumber() {
		HashSet<String> allNumbers = new HashSet<>();
		
		for(HashMap<String, String> group : phoneBook.values()) {
			//phoneBook의 value중에 키 값인 전화번호만 저장
			allNumbers.addAll(group.keySet());
		}
		return allNumbers;
	}
	//6-3. 모든 전화 번호 중에서 중복 체크
	private boolean checkDupleNumber(String number) {
		return getAllNumber().contains(number);
	}
	
	//7. 전화번호의 일부를 입력하면 입력한 부분과 일치하는 모든 사람의 목록을 출력하는 메서드
	public void searchByNumber(String number) {
		System.out.println("* * * * *"+number+"* * * * *");
		for(HashMap<String, String> group : phoneBook.values()) {
			//전화번호만 모은 keySet
			for(String key : group.keySet()) {
				System.out.printf("%s : %s\n", group.get(key), key);
			}
		}
	}
	
	//8.이름을 입력하면 해당하는 사람의 전화번호를 모두 출력하는 메서드(동명이인이 있는 경우 여러개 출력)
	public void searchByName(String inputName) {
		System.out.println("* * * * *"+inputName+"* * * * *");
		for(HashMap<String, String> group : phoneBook.values()) {
			for(Entry<String, String> entry : group.entrySet()) {
				String number = entry.getKey();
				String name = entry.getValue();
				if(name.contains(inputName)) {
					System.out.printf("%s : %s\n", name, number);
				}
			}
			
		}
	}
	// *** 변경된 내용이 파일에 저장되어 프로그램을 다시 실행할 때도 유지되도록 만들어 주세요.!!!
	//9-1. 파일 저장
	public void save() {
		FileWriter out = null;
		
		try {
			//9-5 전화번호부의 내용을 문자열로 구성하여 파일에 저장하기(직렬화 사용가능)
			out = new FileWriter(saveFile);
			for(String groupName : phoneBook.keySet()) {
				out.write(groupName + ":");
				for(Entry<String, String> e : phoneBook.get(groupName).entrySet()) {
					out.write(String.format("%s=%s", e.getKey(), e.getValue()));
				}
				out.write('\n');
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(out != null) Closer.close(out);
		}
	}
	
	//10-1. 로드 - 저장된 파일 불러오기
	public void load() {
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new FileReader(saveFile));
			String line = null;
			while((line=in.readLine()) != null) {
				String[] groupAndEntry = line.split(":");
				if(groupAndEntry.length == 1) { //추가할 데이터가 하나라면 구분값 필요 X
					addGroup(groupAndEntry[0]);
				}else {//추가할 데이터가 2개 이상이면 구분값이 필요
					addGroup(groupAndEntry[0]);
					String [] entry = groupAndEntry[1].split(" "); //전화번호, 이름 구분값
					
					for(String e : entry) {
						String[] phoneAndName = e.split("=");
						addPhoneNo(groupAndEntry[0], phoneAndName[0], phoneAndName[1]);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) Closer.close(in);
		}
	}
	
}

//5. 상태 정보 메세지를 전달하는 클래스 - 기능 실행 후 결과에 대한 메세지 전달
// ......... 이게 뭐하는 건지는 알겠는데 어떻게 해야 적절하게 사용할 수 있는지 잘 생각이 안난다
class AddphMessage{
	String msg;
	int type;
	
	final static int NOT_EXISTING_GROUP = 0;	//그룹이 없는 경우
	final static int EXISTING_NUMBER = 1;	//그룹이 있는 경우
	final static int ADD_SUCCESS = 2;	//작업 성공한 경우
	
	public AddphMessage(String msg, int type) {
		this.msg = msg;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return msg;
	}
}
