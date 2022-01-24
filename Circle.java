package shapes.impl;

import shapes.Shape;

public class Circle extends Shape {

	private static final long serialVersionUID = 1L;

	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double area() {
		return Math.PI * radius * radius;
	}

	@Override
	public double perimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public String toString() {
		return String.format("Circle [radius = %s, area = %s, perimeter = %s]", radius, area(), perimeter());
	}

}
