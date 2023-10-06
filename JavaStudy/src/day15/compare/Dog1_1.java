package day15.compare;
//객체간 동등 비교 : equals, hashcode 를 재정의하여 비교한다.
//리스트에 넣어서 객체간 비교를 하기 위해 클래스를 만든다.
public class Dog1_1 {
	//1. 비교할 멤버변수 생성
	String dogId;
	String dogName;
	int weight;
	
	//2. 객체 생성 시 각 객체의 데이터를 받아 올 생성자 제작
	Dog1_1(String dogId, String dogName, int weight) {
		this.dogId = dogId;
		this.dogName = dogName;
		this.weight = weight;
	}
	
	//3. 데이터 확인을 위한 toString() 오버라이드
	@Override
	public String toString() {
		return "Dog [dogId = "+dogId+", dogName = "+dogName+"]"+this.hashCode();
	}
	
	//????????????????????여기 getter, setter는 왜 쓰는거지?
	//답: 같은 패키지 내에서는 멤버변수에 접근할 수 있지만 패키지가 달라지면 접근할 수 없기 때문에 getter/setter를 사용한다.
	
	//4. equals() 오버라이드
	//***hashcode가 낮은 확률로 똑같은 경우도 있어서 equals도 같이 사용해서 비교해야 한다.
	@Override
	public boolean equals(Object obj) {
		//5. 비교하는 객체가 서로 다른지 판단하는 조건 작성
		//생성된 객체 그 자체를 비교(주소값까지 비교, 최소한의 조건)
		if(this == obj) return true;
		//비교할 obj 객체가 생성되지 않았을 경우
		if(obj == null) return false;
		//각 객체의 클래스가 서로 다를 경우
		if(getClass() != obj.getClass()) return false;
		
		//6. 비교하는 객체 내부 멤버 비교
		Dog1_1 other = (Dog1_1)obj;
		//dogId 비교
		//dogId가 애초에 없는데
		if(dogId == null) {
			//비교할 dogId가 있는 경우
			if(other.dogId != null) return false; 
		//dogId가 다른 경우
		}else if(!dogId.equals(other.dogId)) return false;
		//?????????????? 이 equals는 지금 오버라이드 하는 equals랑 다른거겠지?
		//답: 다름 String의 equals임
		
		//dogName 비교
		//dogName이 애초에 없는데
		if(dogName == null) {
			//비교할 dogName이 있는 경우
			if(other.dogName != null) return false;
		//dogName이 다른 경우	
		}else if(!dogName.equals(other.dogName)) return false;
		
		//weight 비교
		//weight가 다른 경우
		//???????????????? 왜 weight는 애초에 없는 경우 비교는 없지??
		//답: 기준에 따라 다름 여기서는 안하기로 함
		if(weight != other.weight) return false;
		
		//비교를 모두 통과함
		return true;
	}
	
	//7. hashcode() 오버라이드
	@Override
	public int hashCode() {
		//8. hashcode 차이 구분용 큰 상수 지정
		final int prime = 31;
		int result = 1; 
		//?????????????? 왜 1이지? 0이어도 상관없는거 아닌가?
		//답 : 기본값을 1로 설정한 것. 다른 값도 가능함
		
		//9. 내부 멤버 hashcode 비교
		result = prime * result + ((dogId == null) ? 0 : dogId.hashCode());
		result = prime * result + ((dogName == null) ? 0 : dogName.hashCode());
		result = prime * weight;
		
		return result;
	}
	
	
	
	
	
	
	
	
	
}
