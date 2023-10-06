package day20.stream;
//객체 비교를 위해 참조할 클래스 생성
public abstract class Shape_1 implements Comparable<Shape_1> {
	//1. 필드, 생성자, 메서드 생성(좌표를 구할 때 사용)
	int x, y;
	
	public Shape_1() {}
	
	public Shape_1(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String getLocation() {
		return "x : "+x+", y : "+y;
	}
	
	
	//2. 각자 다른 계산식으로 구현할 추상 메서드 생성
	public abstract double area(); 
	public abstract double length(); 	
	//????? 추상 메서드 반환타입이 꼭 필요했던가? 매개변수를 쓸 수 있던가? 기억이 안나네
	//답 : 모든 메서드는 반환타입이 필요하다. 필요 없으면 void. 추상 메서드도 매개변수 사용가능 
	
	//3. 넓이 기준 비교 메서드 오버라이드
	@Override
	public int compareTo(Shape_1 o) {
		return (int)(this.area() - o.area());
		//반환 값은 음수, 0, 양수 중 하나여야 비교, 정렬이 가능하다.
		//반환 값이 int여야하니까 double에서 int로 캐스팅 필요
	}
	
}
