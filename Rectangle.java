package shapes.impl;

import shapes.Shape;

public class Rectangle extends Shape {

	private static final long serialVersionUID = 1L;
	private double width;
	private double length;

	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}

	@Override
	public double area() {
		return width * length;
	}

	@Override
	public double perimeter() {
		return (width + length) * 0.5;
	}

	@Override
	public String toString() {
		return String.format("Rectangle [width = %s, length = %s, area = %s, perimeter = %s]", width, length, area(),
				perimeter());
	}
}
