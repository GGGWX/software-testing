package PointTest;// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 1; page ??
// See PointTest.java for JUnit tests
// See also ColorPoint.java

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        // Location A
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return (p.x == this.x) && (p.y == this.y);
    }

    @Override
    public int hashCode(){
        int result = Integer.hashCode(x);
        result = 31 * result + Integer.hashCode(y);
        return result;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static void main(String[] args) {
        Point a = new Point(1, 2);
        Point b = new Point(1, 2);
        System.out.println("a equals b? \n" + a.equals(b));


        HashSet<Point> s = new HashSet<>();
        s.add(a);
        s.add(b);

        Iterator<Point> itr = s.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }


    }


}