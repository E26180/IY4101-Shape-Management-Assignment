/**
 * Rectangle is a concrete subclass of Shape.
 * It stores width and length and calculates area and perimeter.
 */
public class Rectangle extends Shape {
    private int width;
    private int length;

    /** Creates a rectangle using a position, width and length. */
    public Rectangle(Coordinates coord, int width, int length) {
        super(4, coord);
        this.width = Math.max(0, width);
        this.length = Math.max(0, length);
    }

    /** Returns the area of the rectangle. */
    @Override
    public double getArea() {
        return width * length;
    }

    /** Returns the perimeter of the rectangle. */
    @Override
    public double getPerimeter() {
        return (2 * width) + (2 * length);
    }

    /** Scales the rectangle position, width and length. */
    @Override
    public void scale(int factor, boolean sign) {
        super.scale(factor, sign);

        if (factor <= 0) {
            return;
        }

        if (sign) {
            width = width * factor;
            length = length * factor;
        } else {
            width = width / factor;
            length = length / factor;
        }
    }

    /** Returns a full description of the rectangle. */
    @Override
    public String display() {
        return "Rectangle: position (" + getCoordinates().display() + "), width = " + width
                + ", length = " + length + ", area = " + getArea()
                + ", perimeter = " + getPerimeter();
    }
}
