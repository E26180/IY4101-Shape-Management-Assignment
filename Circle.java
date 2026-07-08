/**
 * Circle is a concrete subclass of Shape.
 * It stores a centre point and radius and calculates area and circumference.
 */
public class Circle extends Shape {
    private int radius;

    /** Creates a circle using a centre coordinate and radius. */
    public Circle(Coordinates coord, int radius) {
        super(0, coord);
        this.radius = Math.max(0, radius);
    }

    /** Returns the area of the circle. */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /** Returns the circumference of the circle. */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /** Scales the circle centre and radius. */
    @Override
    public void scale(int factor, boolean sign) {
        super.scale(factor, sign);

        if (factor <= 0) {
            return;
        }

        if (sign) {
            radius = radius * factor;
        } else {
            radius = radius / factor;
        }
    }

    /** Returns a full description of the circle. */
    @Override
    public String display() {
        return "Circle: centre (" + getCoordinates().display() + "), radius = " + radius
                + ", area = " + String.format("%.2f", getArea())
                + ", perimeter = " + String.format("%.2f", getPerimeter());
    }
}
