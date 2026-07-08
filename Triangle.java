/**
 * Triangle is a concrete subclass of Shape.
 * The inherited position is used as vertex 1, while vertex 2 and vertex 3
 * are stored as separate Coordinates objects.
 */
public class Triangle extends Shape {
    private Coordinates vertex2;
    private Coordinates vertex3;

    /** Creates a triangle using three vertices. */
    public Triangle(Coordinates vertex1, Coordinates vertex2, Coordinates vertex3) {
        super(3, vertex1);
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
    }

    /** Translates all three vertices of the triangle. */
    @Override
    public void translate(int dx, int dy) {
        getCoordinates().translate(dx, dy);
        vertex2.translate(dx, dy);
        vertex3.translate(dx, dy);
    }

    /** Scales all three vertices of the triangle. */
    @Override
    public void scale(int factor, boolean sign) {
        if (factor <= 0) {
            return;
        }

        getCoordinates().scale(factor, sign);
        vertex2.scale(factor, sign);
        vertex3.scale(factor, sign);
    }

    /** Returns the perimeter of the triangle. */
    @Override
    public double getPerimeter() {
        double a = getCoordinates().distance(vertex2);
        double b = vertex2.distance(vertex3);
        double c = vertex3.distance(getCoordinates());
        return a + b + c;
    }

    /** Returns the area of the triangle using Heron's Formula. */
    @Override
    public double getArea() {
        double a = getCoordinates().distance(vertex2);
        double b = vertex2.distance(vertex3);
        double c = vertex3.distance(getCoordinates());
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    /** Returns a full description of the triangle. */
    @Override
    public String display() {
        return "Triangle: vertex1 (" + getCoordinates().display() + "), vertex2 ("
                + vertex2.display() + "), vertex3 (" + vertex3.display()
                + "), area = " + String.format("%.2f", getArea())
                + ", perimeter = " + String.format("%.2f", getPerimeter());
    }
}
