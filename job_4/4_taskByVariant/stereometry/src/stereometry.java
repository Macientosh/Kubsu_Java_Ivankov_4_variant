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

    public double vectorLength() {
        return Math.sqrt(x * x + y * y);
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

    public double vectorLength() {
        return Math.sqrt(getX() * getX() + getY() * getY() + z * z);
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }
}

public class stereometry {
    public static void main(String[] args) {
        Point point2D = new Point(5, 10);
        System.out.println("2D Point: " + point2D);
        System.out.println("Vector length (2D): " + point2D.vectorLength());

        Point3D point3D = new Point3D(3, 4, 5);
        System.out.println("3D Point: " + point3D);
        System.out.println("Vector length (3D): " + point3D.vectorLength());
    }
}
