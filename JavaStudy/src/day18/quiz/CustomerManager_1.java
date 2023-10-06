package day18.quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import day18.quiz.Customer_1;
import util.Closer;


public class CustomerManager_1 {
//데이터를 보여주고 제어하는 클래스 VC
	//직렬화 한 클래스 사용
	
	//2. Customer를 리스트로 저장할 ArrayList 객체 만들기
	static ArrayList<Customer_1> cusList = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	//11. file을 저장할 경로와 파일 이름을 가진 객체 생성
	static File file = new File("E:\\Develop\\Java\\FirstJAVA\\file\\CostomerManager.txt");
	
	public static void main(String[] args) {
		//17. 기존에 파일이 있다면 프로그램 시작 전에 읽어오기
		readCustomerData();
		
		//3. 메뉴 만들기
		while(true) {
			System.out.println("======== 메뉴를 입력하세요 =======");
			System.out.println("(I)nsert, (W)rite, (S)elect, Select(A)ll, (U)pdate, (D)elete, (Q)uit");
			System.out.print("메뉴 입력 :");
//			scan.nextLine();
			String menu = scan.next();
			//위에 scan.nextline()를 사용하려면 버퍼정리를 해주고 사용하던가 아니면 next()로 바꿔준다.
			menu.toLowerCase();
			
			switch (menu.charAt(0)) { //여러개를 입력할 수도 있으니 제일 앞 글자로 판단
			case 'i':
			case 'ㅑ':
				//데이터 입력
				System.out.println("고객 정보를 입력합니다.");
				insertCustomerData();
				break;
			case 'w':
			case 'ㅈ':
				//데이터 저장
				System.out.println("고객 정보를 파일에 저장합니다.");
				writeCustomerData();
				break;
			case 's':
			case 'ㄴ':
				//데이터 출력(데이터 선택 후 선택한 고객 정보 출력)
				if(cusList.size() > 0) {
					System.out.println("고객 정보를 출력합니다.");
					printCustomerData(selectCustomerData());
					//선택한 데이터를 이용해 출력한다.
				} else {
					System.out.println("저장된 데이터가 없습니다.");
				}
				
				break;
			case 'a':
			case 'ㅁ':
				//전체 데이터 출력
				if(cusList.size() > 0) {
					System.out.println("전체 데이터를 출력합니다.");
					printAllCustomerData();
				} else {
					System.out.println("저장된 데이터가 없습니다.");
				}
				break;
			case 'u':
			case 'ㅕ':
				//데이터 수정
				if(cusList.size() > 0) {
					System.out.println("고객 정보를 수정합니다.");
					updateCustomerData(selectCustomerData());
				}else {
					System.out.println("수정할 고객 정보가 없습니다.");
				}
				break;
			case 'd':
			case 'ㅇ':
				//데이터 삭제
				if(cusList.size() > 0) {
					System.out.println("고객 정보를 삭제합니다.");
					deleteCustomerData(selectCustomerData());
				}else {
					System.out.println("삭제할 고객 정보가 없습니다.");
				}
				break;
			case 'q':
			case 'ㅂ':
				System.out.println("시스템을 종료합니다.");
				scan.close();
				System.exit(0);
			default:
				System.out.println("메뉴를 잘못 입력하셨습니다.");
				break;
			}
		}
		
	}
	
	//1. 사용할 메서드 제작
	//데이터 추가
	public static void insertCustomerData() {
		//4. 데이터 추가 메서드
		//고객 정보 입력 받기
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("성별 : ");
		String gender = scan.next();
		System.out.print("이메일 : ");
		String email = scan.next();
		System.out.print("생년월일 : ");
		int birthYear = scan.nextInt();
		
		//입력 받은 정보로 객체 만들어서 리스트에 넣기
		Customer_1 c1 = new Customer_1(name, gender, email, birthYear);
		
		//객체간 동등비교
		for(Customer_1 list : cusList) {
			if(list.equals(c1)) {
				System.out.println("중복된 데이터 입니다.");
				return;
			}
		}
		//???????????? 왜 하나가 달라도 같은 객체라고 반환되는거지?
		//답 : if문을 잘못 써서 그랬음. 수정함
		
		cusList.add(c1);
		System.out.println("고객 정보를 저장했습니다.");
		
	}
	
	//데이터 선택 - 선택만 함
	static Customer_1 selectCustomerData() {
		Customer_1 result = null;
		//5. 데이터 검색 메서드 - 이름으로 검색
		while(true) {
			System.out.println("출력, 수정 또는 삭제할 사람의 이름을 입력해 주세요.");
			System.out.println("메뉴로 돌아가려면 X를 눌러주세요");
			String name = scan.next();
			
			Customer_1 cus = new Customer_1();
//			System.out.println(cusList);
			if(name.equals("X") || name.equals("x") || name.equals("ㅌ")) {
				return cus; //작업을 하지 않고 메뉴로 나갈 때는 빈 리스트를 넘긴다.
			}
			
			for(int i=0; i<cusList.size(); i++) {
				if(cusList.get(i).getName().equals(name)) {
					return cusList.get(i);
				}
			}
			System.out.println("입력하신 이름의 데이터가 존재하지 않습니다.");			
		}		
		
	}
	
	//데이터 출력
	static void printCustomerData(Customer_1 cu) {
		//6. 선택한 데이터 출력
		if(cu.getName() == null) { 
			System.out.println("찾는 사람이 없습니다. 메뉴로 돌아갑니다.");
		}else {
			System.out.println(cu.toString());
		}
		//???????? 데이터 선택 메서드에서 검색하는 이름이 없는 경우를 판단하는데 왜 여기서 또 필요하지?
		//답 : 검색에서 찾는 사람이 없을 때 = null일 때 데이터가 없다고 알려주고 종료되어야 하기 때문이다.
		//여기서 null인지 아닌지 판단하지 않고 출력만하게 되면 null값이 그대로 출력되서 안됨.
//		System.out.println(cu); 
	}
	
	//데이터 전체 출력
	static void printAllCustomerData() {
		//7. 전체 데이터 출력
//		int i = 0;
//		while(i<=cusList.size()-1) { 
//		//i는 0부터 시작해야 cusList의 내용을 0부터 알아 올 수 있음. 그거에 맞추기 위해 -1 해줌
//			System.out.println(cusList.get(i).toString());
//			i++;			
//		}
		//?????? 위에서 cusList에 데이터가 없을 경우를 판단 했는데 왜 여기서 또 while로 판단하는거지?
		for(Customer_1 cu : cusList) {
			System.out.println(cu);
		}
		System.out.println("전체 데이터 출력을 완료했습니다.");
	}
	
	//데이터 수정
	static void updateCustomerData(Customer_1 cu) {
		//8. 선택한 데이터를 수정
		if(cu.getName() == null) {
			System.out.println("수정할 데이터가 없습니다. 메뉴로 돌아갑니다.");
		}else {
			System.out.println("============ 고객 정보 수정 =============");
			System.out.print("이름("+cu.getName()+") : ");
			cu.setName(scan.next());
			System.out.print("성별("+cu.getGender()+") : ");
			cu.setGender(scan.next());
			System.out.print("이메일("+cu.getEmail()+") : ");
			cu.setEmail(scan.next());
			System.out.print("생년월일("+cu.getBirthYear()+") : ");
			cu.setBirthYear(scan.nextInt());
		}		
		
		//????????? if가 왜 필요하지?? 
		//답 : 없는 데이터를 선택 했을 때는 정보를 수정하지 않고 바로 나갈 수 있도록 해야하기 때문
//		System.out.println("============ 고객 정보 수정 =============");
//		System.out.print("이름("+cu.getName()+") : ");
//		cu.setName(scan.next());
//		System.out.print("성별("+cu.getGender()+") : ");
//		cu.setGender(scan.next());
//		System.out.print("이메일("+cu.getEmail()+") : ");
//		cu.setEmail(scan.next());
//		System.out.print("생년월일("+cu.getBirthYear()+") : ");
//		cu.setBirthYear(scan.nextInt());
	}
	
	//데이터 삭제
	static void deleteCustomerData(Customer_1 cu) {
		//9. 선택한 데이터 삭제
		if(cu.getName() == null) {
			System.out.println("메뉴로 돌아갑니다.");
		}else {
			cusList.remove(cu);
			System.out.println("선택한 데이터를 삭제했습니다.");
		}
		//???? if가 왜 필요하지??
		//답 : 위와 같음
//		cusList.remove(cu);
//		System.out.println("선택한 데이터를 삭제했습니다.");
	}
	
	//데이터 저장
	static void writeCustomerData() {
		//10. cusList의 데이터를 파일로 만들기
		
		//12. 파일 존재 유무 판단
		//????????????????? FileWriter처럼 내용 append는 안되나?
		//답 : 
		if(file.exists()) {
			System.out.println("파일이 이미 존재합니다.");
		}else {
			System.out.println("파일이 없습니다.");
			File dir = new File(file.getParent());
			//??????????왜 그냥 file은 안되지? 
			//답 : 그냥 file로 넣으면 File 객체를 넣는 거기 때문에 오류가 남. String을 넣어줘야하는데 getParent()가 String을 반환한다.
			//그리고 부모 디렉터리 생성용이라서 이렇게 써도 된다.
			dir.mkdirs();
		}
		
		//13. 파일 생성 객체 만들기 - 객체 직렬화를 사용했기 때문에 ObjectOutputStream으로 만든다
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			//14. 파일 객체 선언
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(cusList);
			System.out.println("Customer 데이터 저장 완료");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(fos != null) Closer.close(fos);
			if(oos != null) Closer.close(oos);
		}
		
	}
	
	//데이터 읽기
	@SuppressWarnings("unchecked")
	static void readCustomerData() {
		//15. 읽어올 파일 객체 생성
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			//16. 리스트에 파일 내용 넣기
			cusList = (ArrayList<Customer_1>)ois.readObject();
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(fis != null) Closer.close(fis);
			if(ois != null) Closer.close(ois);
		}
	}

}
