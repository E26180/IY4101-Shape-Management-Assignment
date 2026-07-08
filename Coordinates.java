/**
 * The Coordinates class represents a point on a two-dimensional canvas.
 * The origin is assumed to be at the top-left corner, so negative values
 * are not stored.
 */
public class Coordinates {
    private int x;
    private int y;

    /**
     * Creates a coordinate point using x and y values.
     * Negative values are changed to zero to keep coordinates valid.
     */
    public Coordinates(int x, int y) {
        this.x = Math.max(0, x);
        this.y = Math.max(0, y);
    }

    /** Returns the x coordinate. */
    public int getX() {
        return x;
    }

    /** Returns the y coordinate. */
    public int getY() {
        return y;
    }

    /**
     * Calculates the distance from this coordinate to another coordinate.
     */
    public double distance(Coordinates p) {
        int differenceX = this.x - p.getX();
        int differenceY = this.y - p.getY();
        return Math.sqrt((differenceX * differenceX) + (differenceY * differenceY));
    }

    /**
     * Moves the coordinate by adding dx to x and dy to y.
     */
    public void translate(int dx, int dy) {
        x = Math.max(0, x + dx);
        y = Math.max(0, y + dy);
    }

    /**
     * Scales the coordinate. If sign is true, the coordinate is multiplied.
     * If sign is false, the coordinate is divided using integer division.
     */
    public void scale(int factor, boolean sign) {
        if (factor <= 0) {
            return;
        }

        if (sign) {
            x = x * factor;
            y = y * factor;
        } else {
            x = x / factor;
            y = y / factor;
        }
    }

    /** Returns the coordinate information as a string. */
    public String display() {
        return "X = " + x + ", Y = " + y;
    }
}
