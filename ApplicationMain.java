
import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import shapes.Shape;
import shapes.impl.Circle;
import shapes.impl.Square;
import shapes.impl.Triangle;

public class ApplicationMain {

	public static void main(String[] args) throws Exception {

		Square square = new Square(10);
		System.out.println(square);

		Circle circle = new Circle(10);
		System.out.println(circle);

		Triangle triangle = new Triangle(10, 10, 30);
		System.out.println(triangle);

		Collection<Shape> shapes = Arrays.asList(circle, triangle, square);
		System.out.println("Sort by Area asc: " + Shape.sortByArea(shapes, true));
		System.out.println("Sort by Area desc: " + Shape.sortByArea(shapes, false));

		System.out.println("Sort by Perimeter asc: " + Shape.sortByPerimeter(shapes, true));
		System.out.println("Sort by Perimeter desc: " + Shape.sortByPerimeter(shapes, false));

		File file = Shape.serialize(shapes);
		System.out.println("Data serialized and saved at " + file);
		System.out.println("Deserialized Data: " + Shape.deserialize(file, shapes));

		Shape.printObjectsCount();
	}
}
