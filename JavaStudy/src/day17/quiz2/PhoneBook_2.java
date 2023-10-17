package day17.quiz2;

import java.util.HashMap;
import java.util.Set;

public class PhoneBook_2 {

	HashMap<String, HashMap<String, String>> phoneBook;
	
	public PhoneBook_2() {
		phoneBook = new HashMap<>();
	}
	
	public void addGroup(String groupName) {
		if(!phoneBook.containsKey(groupName)) {
			phoneBook.put(groupName, new HashMap<String, String>());
		}
	}
	
	public void printAll() {
		Set<String> groupNames = phoneBook.keySet();
		for(String groupName : groupNames) {
			System.out.println("======="+groupName+"=======");
			
			HashMap<String, String> nameAndNums = phoneBook.get(groupName);
			if(nameAndNums.size() !=0 ) {
				for(String number : nameAndNums.keySet()) {
					System.out.printf("%s : %s", nameAndNums.get(number), number);
				}
			}else {
				System.out.println("데이터가 없습니다.");
			}
		}
	}
}
