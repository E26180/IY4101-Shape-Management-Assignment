import java.util.Scanner;

/**
 * ShapeManagement is the main console application.
 * It provides a menu that allows users to add, remove, display,
 * translate and scale shapes in a ShapeList.
 */
public class ShapeManagement {
    private static Scanner input = new Scanner(System.in);
    private static ShapeList shapes = new ShapeList();

    /** Runs the main menu until the user chooses to quit. */
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addShapeMenu();
                    break;
                case 2:
                    removeShapeByPosition();
                    break;
                case 3:
                    displayShapeByPosition();
                    break;
                case 4:
                    displayAreaAndPerimeterByPosition();
                    break;
                case 5:
                    System.out.println(shapes.display());
                    break;
                case 6:
                    translateAllShapes();
                    break;
                case 7:
                    scaleAllShapes();
                    break;
                case 0:
                    running = false;
                    System.out.println("Program closed.");
                    break;
                default:
                    System.out.println("Invalid menu option. Please try again.");
            }
        }
    }

    /** Displays the main menu options. */
    private static void displayMenu() {
        System.out.println("\nShape Management Application");
        System.out.println("1: add a shape");
        System.out.println("2: remove a shape by position");
        System.out.println("3: get information about a shape by position");
        System.out.println("4: area and perimeter of a shape by position");
        System.out.println("5: display information of all the shapes");
        System.out.println("6: translate all the shapes");
        System.out.println("7: scale all the shapes");
        System.out.println("0: quit program");
    }

    /** Reads an integer safely from the user. */
    private static int readInt(String message) {
        System.out.print(message);
        while (!input.hasNextInt()) {
            System.out.println("Please enter a whole number.");
            input.next();
            System.out.print(message);
        }
        return input.nextInt();
    }

    /** Allows the user to select and add a shape. */
    private static void addShapeMenu() {
        System.out.println("\nChoose shape type:");
        System.out.println("1: Triangle");
        System.out.println("2: Rectangle");
        System.out.println("3: Circle");
        System.out.println("4: Square");
        int shapeChoice = readInt("Enter shape type: ");

        switch (shapeChoice) {
            case 1:
                addTriangle();
                break;
            case 2:
                addRectangle();
                break;
            case 3:
                addCircle();
                break;
            case 4:
                addSquare();
                break;
            default:
                System.out.println("Invalid shape type.");
        }
    }

    /** Adds a triangle using three vertices. */
    private static void addTriangle() {
        int x1 = readInt("Enter vertex 1 x: ");
        int y1 = readInt("Enter vertex 1 y: ");
        int x2 = readInt("Enter vertex 2 x: ");
        int y2 = readInt("Enter vertex 2 y: ");
        int x3 = readInt("Enter vertex 3 x: ");
        int y3 = readInt("Enter vertex 3 y: ");

        shapes.addShape(new Triangle(new Coordinates(x1, y1),
                new Coordinates(x2, y2), new Coordinates(x3, y3)));
        System.out.println("Triangle added successfully.");
    }

    /** Adds a rectangle using position, width and length. */
    private static void addRectangle() {
        int x = readInt("Enter x coordinate: ");
        int y = readInt("Enter y coordinate: ");
        int width = readInt("Enter width: ");
        int length = readInt("Enter length: ");

        shapes.addShape(new Rectangle(new Coordinates(x, y), width, length));
        System.out.println("Rectangle added successfully.");
    }

    /** Adds a circle using centre and radius. */
    private static void addCircle() {
        int x = readInt("Enter centre x coordinate: ");
        int y = readInt("Enter centre y coordinate: ");
        int radius = readInt("Enter radius: ");

        shapes.addShape(new Circle(new Coordinates(x, y), radius));
        System.out.println("Circle added successfully.");
    }

    /** Adds a square using position and side length. */
    private static void addSquare() {
        int x = readInt("Enter x coordinate: ");
        int y = readInt("Enter y coordinate: ");
        int side = readInt("Enter side length: ");

        shapes.addShape(new Square(new Coordinates(x, y), side));
        System.out.println("Square added successfully.");
    }

    /** Removes a shape if the position exists. */
    private static void removeShapeByPosition() {
        int position = readInt("Enter position to remove: ");
        Shape removedShape = shapes.removeShape(position);

        if (removedShape == null) {
            System.out.println("No shape exists at this position.");
        } else {
            System.out.println("Shape removed successfully: " + removedShape.display());
        }
    }

    /** Displays one shape if the position exists. */
    private static void displayShapeByPosition() {
        int position = readInt("Enter position to display: ");
        Shape shape = shapes.getShape(position);

        if (shape == null) {
            System.out.println("No shape exists at this position.");
        } else {
            System.out.println(shape.display());
        }
    }

    /** Displays area and perimeter of one shape if the position exists. */
    private static void displayAreaAndPerimeterByPosition() {
        int position = readInt("Enter position: ");
        Shape shape = shapes.getShape(position);

        if (shape == null) {
            System.out.println("No shape exists at this position.");
        } else {
            System.out.println("Area: " + String.format("%.2f", shape.getArea()));
            System.out.println("Perimeter: " + String.format("%.2f", shape.getPerimeter()));
        }
    }

    /** Translates all shapes by x and y distances. */
    private static void translateAllShapes() {
        int dx = readInt("Enter x distance: ");
        int dy = readInt("Enter y distance: ");
        shapes.translateShapes(dx, dy);
        System.out.println("All shapes translated successfully.");
    }

    /** Scales all shapes by multiplying or dividing by a factor. */
    private static void scaleAllShapes() {
        int factor = readInt("Enter scale factor: ");
        int signChoice = readInt("Enter 1 to multiply or 0 to divide: ");
        boolean sign = signChoice == 1;

        shapes.scale(factor, sign);
        System.out.println("All shapes scaled successfully.");
    }
}
