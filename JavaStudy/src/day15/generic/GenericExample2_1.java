package day15.generic;

import java.util.ArrayList;

//클래스 객체로 generic 제한하기
public class GenericExample2_1 {

	public static void main(String[] args) {
		//7. 지갑 객체 생성
		Wallet<Card, Money> card_Wallet = new Wallet<>("파란색"); 
		//Card, Money 클래스를 상속 받은 객체만 허용
		Wallet<CreditCard, Money> card_Wallet2 = new Wallet<>("하늘색"); 
		//CreditCard, Money 클래스를 상속 받은 객체만 허용
		
		//8. <Card, Money>중 Card를 상속 받은 클래스를 지갑에 담기
		//ArrayList<One> pouch
		card_Wallet.pouch.add(new CreditCard());
		card_Wallet.pouch.add(new CheckCard());
		card_Wallet.pouch.add(new BusCard());
		
		//9. <CreditCard, Money>중 CreditCard를 상속 받은 클래스를 지갑에 담기
		card_Wallet2.pouch.add(new CreditCard());
		
		//10. <CreditCard, Money>중 Money를 상속 받은 클래스를 지갑에 담기
		//ArrayList<Two> pouch2
		card_Wallet2.pouch2.add(new Won());
		card_Wallet2.pouch2.add(new Dollar());
		
		//11. generic 범위 제한 예제
		ArrayList<Integer> int_list = new ArrayList<>();
		ArrayList<String> str_list = new ArrayList<>();
		ArrayList<Object> apple_list = new ArrayList<>();
		
		int_list.add(100);
		int_list.add(new Integer(20));
		str_list.add("스트링으로 제한한 generic");
		str_list.add("스트링 형태만 넣을 수 있다.");
		apple_list.add(new Person_1<String>("홍길동", 15));
		//??????????????? <String>말고 그냥 E를 넣으면 오류가 남 왜지? E extends Object니까 String도 되지 않나?
		
		//13. 와일드 카드로 오버로드한 메서드 사용
		usingArrayListMethod(int_list); //매개변수의 generic과 상관없이 매개변수로 사용가능하다. 
		usingArrayListMethod(str_list);
		usingArrayListMethod(apple_list);
		
		usingArrayListMethod(card_Wallet);//와일드 카드를 썼기 때문에 generic과 상관없이 사용 가능.
		usingArrayListMethod(card_Wallet2);
		
	}
	
	//12. 와일드 카드 <?>
	//매개 변수의 generic 타입에 상관없이 오버로드를 구현할 때 사용
	//generic이 다른 것 만으로는 메서드 구분이 되지 않기 때문에 오버로드 할 수 없지만 와일드 카드를 쓰면 가능하다.
	//특정 generic에만 기능을 주고 싶다면 내부에서 insteadOf로 generic을 구분하여 사용
	static void usingArrayListMethod(ArrayList<?> list) {
		System.out.println(list);
	}
	
	static void usingArrayListMethod(Wallet<? extends Card, ? extends Money> w) {
		System.out.println(w);
	}
}


//1. generic으로 사용할 클래스 만들기
class Card{}
class CreditCard extends Card{}
class CheckCard extends Card{}
class BusCard extends Card{}

class Money{}
class Won extends Money{}
class Dollar extends Money{}

//2. 지갑 클래스 생성, generic 범위 제한
class Wallet<One extends Card, Two extends Money> {
	//3. generic으로 범위 제한한 멤버 변수 생성
	ArrayList<One> pouch;	//Card를 상속 받는 클래스만 허용
	ArrayList<Two> pouch2;	//Money를 상속 받는 클래스만 허용
	String color;
	
	//4. 초기화 및 객체 생성 생성자
	public Wallet(String color) {
		pouch = new ArrayList<>();
		pouch2 = new ArrayList<>();
		this.color = color;
	}
	
	//5.
	public One get(int index) {
		return pouch.get(index);
	}
	
	//6. 내용 출력 오버라이드
	@Override
	public String toString() {
		return "지갑의 내용물을 출력합니다.";
	}
	
}
