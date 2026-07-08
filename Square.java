/**
 * Square is a concrete subclass of Shape.
 * It stores one side length and calculates area and perimeter.
 */
public class Square extends Shape {
    private int side;

    /** Creates a square using a position and side length. */
    public Square(Coordinates coord, int side) {
        super(4, coord);
        this.side = Math.max(0, side);
    }

    /** Returns the area of the square. */
    @Override
    public double getArea() {
        return side * side;
    }

    /** Returns the perimeter of the square. */
    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    /** Scales the square position and side length. */
    @Override
    public void scale(int factor, boolean sign) {
        super.scale(factor, sign);

        if (factor <= 0) {
            return;
        }

        if (sign) {
            side = side * factor;
        } else {
            side = side / factor;
        }
    }

    /** Returns a full description of the square. */
    @Override
    public String display() {
        return "Square: position (" + getCoordinates().display() + "), side = " + side
                + ", area = " + getArea() + ", perimeter = " + getPerimeter();
    }
}
