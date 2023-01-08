import java.awt.geom.Point2D;

public class RotateSquare {

    // Rotate the point (x, y) by the given angle around the origin (0, 0)
    public static Point2D rotatePoint(double x, double y, double angle) {
        double xRotated = x * Math.cos(angle) - y * Math.sin(angle);
        double yRotated = x * Math.sin(angle) + y * Math.cos(angle);
        return new Point2D.Double(xRotated, yRotated);
    }

    // Rotate the square with vertices (x1, y1), (x2, y2), (x3, y3), (x4, y4)
    // by the given angle around the origin (0, 0)
    public static void rotateSquare(double x1, double y1, double x2, double y2,
                                    double x3, double y3, double x4, double y4, double angle) {
        Point2D p1 = rotatePoint(x1, y1, angle);
        Point2D p2 = rotatePoint(x2, y2, angle);
        Point2D p3 = rotatePoint(x3, y3, angle);
        Point2D p4 = rotatePoint(x4, y4, angle);

        System.out.println("Vertices after rotation:");
        System.out.println("(" + p1.getX() + ", " + p1.getY() + ")");
        System.out.println("(" + p2.getX() + ", " + p2.getY() + ")");
        System.out.println("(" + p3.getX() + ", " + p3.getY() + ")");
        System.out.println("(" + p4.getX() + ", " + p4.getY() + ")");
    }

    public static void main(String[] args) {
        // Rotate the square with vertices (1, 1), (1, -1), (-1, -1), (-1, 1)
        // 90 degrees counterclockwise around the origin (0, 0)
        rotateSquare(1, 1, 1, -1, -1, -1, -1, 1, Math.PI / 2);
    }
}
