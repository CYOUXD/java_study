package day17.serializable;

import java.io.Serializable;

public class Customer_1 implements Serializable {
	//Customer 밑줄 위에 마우스를 가져다 대면 + 아이콘 두개가 있음
	//default는 1의 값을 가진 시리얼 넘버, 2번째는 랜덤한 숫자로 이루어진 시리얼 넘버
	//private static final long serialVersionUID = 1L;
	private static final long serialVersionUID = 8453619258708624488L;

	private String name;
	private char gender;
	private String email;
	private int age;
	
	public Customer_1() {}

	public Customer_1(String name, char gender, String email, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", gender=" + gender + ", email=" + email + ", age=" + age + "]";
	}
	
}
