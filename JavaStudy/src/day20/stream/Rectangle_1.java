package day20.stream;

public class Rectangle_1 extends Shape_1 {
	int w, h;
	
	//1. 생성자
	public Rectangle_1() {}
	
	public Rectangle_1(int w, int h) {
		this.w = w;
		this.h = h;
	}
	//2. 도형에 맞는 계산식 구현
	@Override
	public double area() {
		return w*h;
	}

	@Override
	public double length() {
		return (w+h)*2;
	}
	
	//출력용
	@Override
	public String toString() {
		return "넓이 : "+this.area()+", 둘레 : "+this.length();
	}

}
