import java.util.ArrayList;

/**
 * ShapeList stores and manages a collection of Shape objects.
 * Polymorphism allows Triangle, Rectangle, Square and Circle objects
 * to be handled through the Shape type.
 */
public class ShapeList {
    private ArrayList<Shape> listofShapes;

    /** Creates an empty shape list. */
    public ShapeList() {
        listofShapes = new ArrayList<>();
    }

    /** Adds a shape to the list. */
    public void addShape(Shape s) {
        listofShapes.add(s);
    }

    /** Translates every shape in the list. */
    public void translateShapes(int dx, int dy) {
        for (Shape shape : listofShapes) {
            shape.translate(dx, dy);
        }
    }

    /** Returns a shape from a valid position or null if the position is invalid. */
    public Shape getShape(int pos) {
        if (pos >= 0 && pos < listofShapes.size()) {
            return listofShapes.get(pos);
        }
        return null;
    }

    /** Removes a shape from a valid position or returns null if the position is invalid. */
    public Shape removeShape(int pos) {
        if (pos >= 0 && pos < listofShapes.size()) {
            return listofShapes.remove(pos);
        }
        return null;
    }

    /** Returns the area of a shape at a valid position. */
    public double area(int pos) {
        Shape shape = getShape(pos);
        if (shape != null) {
            return shape.getArea();
        }
        return -1;
    }

    /** Scales every shape in the list. */
    public void scale(int factor, boolean sign) {
        for (Shape shape : listofShapes) {
            shape.scale(factor, sign);
        }
    }

    /** Returns the perimeter of a shape at a valid position. */
    public double perimeter(int pos) {
        Shape shape = getShape(pos);
        if (shape != null) {
            return shape.getPerimeter();
        }
        return -1;
    }

    /** Returns the number of shapes in the list. */
    public int getNumberOfShapes() {
        return listofShapes.size();
    }

    /** Returns information about all shapes in the list. */
    public String display() {
        if (listofShapes.isEmpty()) {
            return "There are no shapes in the list.";
        }

        String result = "";
        for (int i = 0; i < listofShapes.size(); i++) {
            result += "Position " + i + ": " + listofShapes.get(i).display() + "\n";
        }
        return result;
    }
}
