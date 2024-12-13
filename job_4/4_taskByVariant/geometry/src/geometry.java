
class Point {
    private int x, y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int distanceFromOrigin() {
        return (int) Math.sqrt(x * x + y * y);
    }

    public boolean isInRectangle(Point topLeft, Point bottomRight) {
        return (this.x >= topLeft.getX() && this.x <= bottomRight.getX() &&
                this.y >= topLeft.getY() && this.y <= bottomRight.getY());
    }

    public boolean isInCircle(Point center, int radius) {
        int dx = this.x - center.getX();
        int dy = this.y - center.getY();
        return dx * dx + dy * dy <= radius * radius;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class Point3D extends Point {
    private int z;

    public Point3D() {
        super();
        this.z = 0;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    @Override
    public int distanceFromOrigin() {
        return (int) Math.sqrt(getX() * getX() + getY() * getY() + z * z);
    }

    public boolean isInBox(Point3D corner1, Point3D corner2) {
        return (this.getX() >= corner1.getX() && this.getX() <= corner2.getX() &&
                this.getY() >= corner1.getY() && this.getY() <= corner2.getY() &&
                this.z >= corner1.getZ() && this.z <= corner2.getZ());
    }

    public boolean isInSphere(Point3D center, int radius) {
        int dx = this.getX() - center.getX();
        int dy = this.getY() - center.getY();
        int dz = this.z - center.getZ();
        return dx * dx + dy * dy + dz * dz <= radius * radius;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }
}

public class geometry {
    public static void main(String[] args) {
        Point point2D = new Point(5, 10);
        System.out.println("2D Point: " + point2D);

        Point3D point3D = new Point3D(3, 4, 5);
        System.out.println("3D Point: " + point3D);

        System.out.println("Distance from origin (2D): " + point2D.distanceFromOrigin());
        System.out.println("Distance from origin (3D): " + point3D.distanceFromOrigin());

        Point topLeft = new Point(0, 0);
        Point bottomRight = new Point(10, 10);
        System.out.println("Point inside rectangle: " + point2D.isInRectangle(topLeft, bottomRight));

        Point3D sphereCenter = new Point3D(0, 0, 0);
        System.out.println("Point inside sphere: " + point3D.isInSphere(sphereCenter, 10));

        Point3D corner1 = new Point3D(0, 0, 0);
        Point3D corner2 = new Point3D(10, 10, 10);
        System.out.println("Point inside box: " + point3D.isInBox(corner1, corner2));
    }
}
