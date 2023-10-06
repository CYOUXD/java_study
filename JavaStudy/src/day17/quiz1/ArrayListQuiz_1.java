package day17.quiz1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListQuiz_1 {

	public static void main(String[] args) {
		//1. User를 저장하는 List를 선언
		List<User_1> people = new ArrayList<>();
		
		//2. 입력 받을 객체 생성
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("메뉴를 입력하세요.");
			System.out.println("[ 1. 회원 등록 | 2. 전체 회원 정보 보기 | 3. 회원정보 검색 | 4. 회원정보 삭제 | 5. 종료 ]");
			System.out.print(">>> ");
			int menu = scan.nextInt();
			
			if(menu == 1) {
				/*
				Scanner를통해 이름과, 나이를 입력받고 User객체에 저장합니다.
				그리고 User객체를 list에 추가하세요.
				*/
				//????????????????? 왜 여기서 버퍼 정리를 해야하지??
				//답:처음에 입력 받았던 메뉴 선택한 1이 남아 있어서 건너 뛰고 실행되어버리기 때문에 버퍼 정리를 해 줘야 한다. 버퍼 정리는 nextLine()으로 한다.
				//3. 회원 정보 입력
				scan.nextLine(); //버퍼 정리
				System.out.println("======= 회원 정보 입력 =======");
				System.out.println("회원 이름 입력 : ");
				String name = scan.nextLine();
				System.out.println("회원 나이 입력 : ");
				int age = scan.nextInt();
				
				//4. people 리스트에 담을 객체 생성
				User_1 user = new User_1(name, age);
				people.add(user);
				System.out.println("회원 정보 정상 처리");				
				
			}else if(menu == 2) {
				System.out.println("====== 모든 회원 정보 ======");
				/*
				 * people의 길이만큼 회전하면서 people의객체를 꺼내 저장합니다. (객체의 타입에 유의)
				 * 꺼낸 하나의 객체에서  공개된 메서드를 통해 이름, 나이를 출력하세요.
				 * 
				 */
				//5. 모든 회원 정보 출력
				for(int i=0; i<people.size(); i++) {
					User_1 user = people.get(i);
					System.out.printf("[ 이름 : %s, 나이 : %d]\n",user.getName(), user.getAge());
				}
				System.out.println("==========================");
				
			}else if(menu == 3) {
				//6. 회원 정보 검색
				System.out.println("찾을 이름을 입력하세요.");
				System.out.print(">>> ");
				String name = scan.next();
				
				//리스트 내부의 클래스 객체에서 이름만 가져오기
				for(int i=0; i<people.size(); i++) {
					User_1 p = people.get(i);
					String pName = p.getName();
					
					if(pName.equals(name)) {
						System.out.println("이름: " + name + ", 나이: " + p.getAge());
						break;
					}
					//???????????????? people list에 저장된 목록이 없고 -1하면 i랑 -1이랑 같아질 일이 없지 않나??
					//답: 이 for문에 들어오려면 people의 사이즈가 0보다 커야 들어올 수 있으므로 people.size()-1이 -1이 될 일이 없음
					if(i == people.size()-1) {
						System.out.println(name +"님은 목록에 없습니다.");
					}
				}
				
				
			}else if(menu == 4) {
				/*
				 * 1. scan 을 통해 삭제할 이름을 입력 받으세요.
				 * 2. list 의 길이 만큼 회전하면서 객체에서 name을 꺼내 비교합니다.
				 * 3. 입력받은 이름과 동일한 이름이 있다면 people객체를 삭제
				 * 
				 */
				
				//7. 회원 삭제하기
				System.out.print("삭제할 이름을 입력하세요. : ");
				String delName = scan.nextLine();
				
				for(int i=0; i<people.size(); i++) {
					User_1 user = people.get(i);
					String name = user.getName();
					
					if(delName.equals(name)) {
						people.remove(i);
					}
				}
				
			}else if(menu == 5) {
				scan.close();
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}

}
