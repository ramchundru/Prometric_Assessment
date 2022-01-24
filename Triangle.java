package shapes.impl;

import shapes.Shape;

public class Triangle extends Shape {

	private static final long serialVersionUID = 1L;

	private double sideB;
	private double sideA;
	private double sideC;

	public Triangle(double sideA, double sideB, double sideC) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	@Override
	public double area() {
		return 0.5 * Math.min(sideA, Math.min(sideB, sideC)) * Math.max(sideA, Math.max(sideB, sideC));
	}

	@Override
	public double perimeter() {
		return sideA + sideB + sideC;
	}

	@Override
	public String name() {
		if (sideA == sideB && sideB == sideC) {
			return "Equilateral Triangle";
		}
		if (sideA != sideB && sideB != sideC) {
			return "Scalene Triangle";
		}
		if ((sideA == sideB && sideB != sideC) || (sideB == sideC && sideA != sideC)
				|| (sideA == sideC && sideB != sideC)) {
			return "Isosceles Triangle";
		}
		return "Unknown Triangle";
	}

	@Override
	public String toString() {
		return String.format("%s [sideA = %s, sideB = %s, sideC = %s, area = %s, perimeter = %s]", name(), sideA, sideB,
				sideC, area(), perimeter());
	}

}
