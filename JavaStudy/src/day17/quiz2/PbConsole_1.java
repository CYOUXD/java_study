package day17.quiz2; //다시 제대로 하기

import java.util.Scanner;

public class PbConsole_1 {

	//폰 북 객체 멤버 제작
	static PhoneBook_1 book = new PhoneBook_1();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		while (true) {
			System.out.println("==== What to do ====");			
			System.out.println("1. New Group");
			System.out.println("2. Print");
			System.out.println("3. New Address");
			System.out.println("4. Find Phone");
			System.out.println("5. Find Name");
			System.out.println("6. Exit");
			System.out.print("> ");
			int behavior = sc.nextInt();
			sc.nextLine();
			
			switch (behavior) {
			case 1:
				doNewGroup();
				break;
			case 2:
				book.printAll();
				break;
			case 3:
				doNewAddress();
				break;
			case 4:	
				findPhone();
			case 5:
			case 6:
			default:
				break;
			}
		}		

	}
	
	public static void doNewGroup() {
		System.out.print("Enter New Group Name : ");
		book.addGroup(sc.nextLine());
		book.save();//정보가 변경될 때 마다 저장
		System.out.println();
	}

	public static void printAll() {

	}
	
	public static void doNewAddress() {
		System.out.print("Enter Group Name :");
		String groupName = sc.nextLine();
		System.out.print("Enter Phone Number :");
		String number = sc.nextLine();
		System.out.print("Enter Name :");
		String name = sc.nextLine();
		
		AddphMessage addMsg = book.addPhoneNo(groupName, number, name);
		
		if(addMsg.type == AddphMessage.ADD_SUCCESS) {
			book.save();
		}else if(addMsg.type == AddphMessage.NOT_EXISTING_GROUP) {
			return;
		}else if(addMsg.type == AddphMessage.EXISTING_NUMBER) {
			
		}
	}
	
	public static void findPhone() {

		
	}

}
