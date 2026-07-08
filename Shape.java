/**
 * Shape is the abstract parent class for all shape types.
 * It stores the common position and number of sides, while area,
 * perimeter and display are implemented by each subclass.
 */
public abstract class Shape {
    private Coordinates position;
    private int sides;

    /** Creates a shape with a number of sides and a position. */
    public Shape(int noOfSides, Coordinates coord) {
        this.sides = noOfSides;
        this.position = coord;
    }

    /** Returns the shape position. */
    public Coordinates getCoordinates() {
        return position;
    }

    /** Returns the number of sides. */
    public int getSides() {
        return sides;
    }

    /** Changes the position of the shape. */
    public void setCoordinates(Coordinates newcoord) {
        this.position = newcoord;
    }

    /** Translates the position of the shape. */
    public void translate(int dx, int dy) {
        position.translate(dx, dy);
    }

    /** Scales the position of the shape. */
    public void scale(int factor, boolean sign) {
        position.scale(factor, sign);
    }

    /** Returns the area of the shape. */
    public abstract double getArea();

    /** Returns the perimeter of the shape. */
    public abstract double getPerimeter();

    /** Returns the shape information as a string. */
    public abstract String display();
}
