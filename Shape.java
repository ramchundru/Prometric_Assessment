package shapes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public abstract class Shape implements Serializable {

	private static final Map<String, Integer> COUNT = new ConcurrentHashMap<>();

	protected Shape() {

		String key = this.getClass().getSimpleName();
		COUNT.put(key, COUNT.getOrDefault(key, 0) + 1);
	}

	private static final long serialVersionUID = 1L;

	public String name() {
		return this.getClass().getSimpleName();
	}

	public abstract double area();

	public abstract double perimeter();

	public static Collection<Shape> sortByArea(Collection<Shape> shapes, boolean sortAsc) {
		if (shapes == null || shapes.isEmpty()) {
			return shapes;
		}
		Comparator<Shape> comp = sortAsc
				? (s1, s2) -> Double.valueOf(s1.area()).compareTo(Double.valueOf(s2.area()))
				: (s1, s2) -> Double.valueOf(s2.area()).compareTo(Double.valueOf(s1.area()));

		return sort(shapes, comp);
	}

	public static Collection<Shape> sortByPerimeter(Collection<Shape> shapes, boolean sortAsc) {
		if (shapes == null || shapes.isEmpty()) {
			return shapes;
		}
		Comparator<Shape> comp = sortAsc
				? (s1, s2) -> Double.valueOf(s1.perimeter()).compareTo(Double.valueOf(s2.perimeter()))
				: (s1, s2) -> Double.valueOf(s2.perimeter()).compareTo(Double.valueOf(s1.perimeter()));

		return sort(shapes, comp);
	}

	private static Collection<Shape> sort(Collection<Shape> shapes, Comparator<Shape> comp) {
		if (shapes.stream().findFirst().get() instanceof List) {
			shapes = shapes.stream().sorted(comp).collect(Collectors.toList());
		} else {
			shapes = shapes.stream().sorted(comp).collect(Collectors.toSet());
		}
		return shapes;
	}

	public static File serialize(Object shapes) throws IOException {
		if (shapes == null) {
			return null;
		}

		File file = new File(String.format("%s.ser", System.nanoTime()));
		try (FileOutputStream stream = new FileOutputStream(file);
				ObjectOutputStream out = new ObjectOutputStream(stream)) {
			out.writeObject(shapes);
			return file;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T deserialize(File file, T shapeType) throws IOException, ClassNotFoundException {
		if (file == null || !file.exists()) {
			throw new IOException("file is either null or not exists");
		}
		try (FileInputStream stream = new FileInputStream(file);
				ObjectInputStream out = new ObjectInputStream(stream)) {
			return (T) out.readObject();
		}
	}

	public static void printObjectsCount() {

		System.out.println("\n--- Created Objects and Count ---\n\n" +
				COUNT.entrySet().stream()
						.map(e -> String.format("%15s  %15s", "Class: " + e.getKey(), "Objects: " + e.getValue()))
						.collect(Collectors.joining(System.lineSeparator())));

	}

}
