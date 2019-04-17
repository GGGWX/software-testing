package PointTest;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import javax.imageio.ImageTypeSpecifier;

import static org.junit.Assert.assertEquals;

/**
 * Point Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Apr 4, 2019</pre>
 */

@RunWith(Theories.class)
public class PointTest {
    @DataPoint
    public static Point a = new Point(1, 1);
    @DataPoint
    public static Point b = new Point(1, 2);
    @DataPoint
    public static Point c = new Point(1, 1);

    @Theory
    public void testPoint(Point x, Point y) {
        assertEquals(x, y);
        System.out.println("Passed with: first point=(" + x.getX() + "," + x.getY() + ")"
                + ", second point=(" + y.getX() + "," + y.getY() + ")");
    }


    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: equals(Object o)
     */
    @Test
    public void testEquals() throws Exception {
//TODO: Test goes here...
        Point aa = new Point(1, 2);
        Point bb = new Point(1, 2);

        assertEquals(aa, bb);
        System.out.println(aa.equals(bb));
        System.out.println("--------");
        System.out.println(aa.hashCode());
        System.out.println(bb.hashCode());
    }

    /**
     * Method: main(String[] args)
     */
    @Test
    public void testMain() throws Exception {
//TODO: Test goes here...
    }


}
