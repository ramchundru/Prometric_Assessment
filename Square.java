package shapes.impl;

import shapes.Shape;

public class Square extends Shape {

	private static final long serialVersionUID = 1L;

	private double side;

	public Square(double side) {
		this.side = side;
	}

	@Override
	public double area() {
		return side * side;
	}

	@Override
	public double perimeter() {
		return 4*side;
	}

	@Override
	public String toString() {
		return String.format("Square [side = %s, area = %s, perimeter = %s]", side, area(), perimeter());
	}
}
