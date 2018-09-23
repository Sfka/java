public class Point {
    public Point p1;
    public Point p2;

    public Point(p1,p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double distance(Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }
}




