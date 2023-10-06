package day18.quiz;

import java.io.Serializable;

					  //1.객체 직렬화 사용 : 객체 정보를 객체 단위로 전송 할 수 있도록 변환하는 것
public class Customer_1 implements Serializable{
//데이터를 저장하는 DB처럼 사용할 클래스 - day18_quiz.png 참고
	//직렬화로 저장되는 데이터는 멤버변수 데이터만 저장되고 생성자나 메서드는 저장되지 않는다.

	private static final long serialVersionUID = 6918880572728797582L;
	
	//2. 필드 생성
	private String name;
	private String gender;
	private String email;
	private int birthYear;
	
	//3. 생성자 생성
	public Customer_1() {}

	public Customer_1(String name, String gender, String email, int birthYear) {
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.birthYear = birthYear;
	}

	//4. getter setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	@Override
	public String toString() {
		return "[이름  : "+name+", 성별 : "+gender+", e-mail : "+email+", 생년월일 : "+birthYear+"]";
	}
	
	//5. 객체간 동등비교를 위한 equals, hashcode
	@Override
	public boolean equals(Object obj) {
		//객체 자체 비교
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		
		//객체 내부 비교
		Customer_1 other = (Customer_1)obj;
		//이름 비교
		if(name == null) {
			if(other.getName() != null) return false;
		}
		else if(!name.equals(other.getName())) return false;
		
		//성별 비교
		if(gender == null) {
			if(other.getGender() != null) return false;
		}
		else if(!gender.equals(other.getGender())) return false;
		
		//이메일 비교
		if(email == null) {
			if(other.getEmail() != null) return false;
		}
		else if(!email.equals(other.getEmail())) return false;
		
		//생년월일 비교
		if(birthYear == 0) {
			if(other.getBirthYear() != 0) return false;
		}
		else if(!(birthYear == other.getBirthYear())) return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		
		result = prime*result+((name == null)?0:name.hashCode());
		result = prime*result+((gender == null)?0:gender.hashCode());
		result = prime*result+((email == null)?0:email.hashCode());
//		result = prime*result+((birthYear == 0)?0:birthYear.hashCode());
		//int 형은 hashcode를 호출할 수 없다.
		result = prime*birthYear;
		
		return result;
	}
	
	
}
