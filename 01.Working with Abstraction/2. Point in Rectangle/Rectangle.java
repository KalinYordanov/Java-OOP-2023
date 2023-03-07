package PointInRectangle;

public class Rectangle {

    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point p) {
        boolean isValidX = p.getX() >= this.bottomLeft.getX() && p.getX() <= this.topRight.getX();
        boolean isValidY = p.getY() >= this.bottomLeft.getY() && p.getY() <= this.topRight.getY();

        return isValidX && isValidY;
    }
}
