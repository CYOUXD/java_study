package day20.stream;

public class Circle_1 extends Shape_1 {
	int r;
	
	//1. 생성자
	public Circle_1() {}
	
	public Circle_1(int r) {
		this.r = r;
	}
	
	//2. 도형에 맞는 계산식 구현
	@Override
	public double area() {
		return (r*r)*Math.PI;
	}

	@Override
	public double length() {
		return (2*r*Math.PI);
	}
	
	@Override
	public String toString() {
		return "넓이 : "+this.area()+", 둘레 : "+this.length();
	}

}
