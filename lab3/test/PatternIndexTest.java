
import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.*;

/** 
* PatternIndex Tester. 
* 
* @author <Authors name> 
* @since <pre>Apr 18, 2019</pre> 
* @version 1.0 
*/ 
public class PatternIndexTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: main(String[] argv) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: patternIndex(String subject, String pattern) 
* 
*/

    // "xxx" and "xxx"
    @Test
    public void testPatternIndex() throws Exception {
    //TODO: Test goes here...
        String subject = "abc";
        String pattern = "abc";
        assertEquals(0, PatternIndex.patternIndex(subject, pattern));
    }

    @Test
    public void testPatternIndex2() throws Exception {
//TODO: Test goes here...
        String subject = "abcd";
        String pattern = "abc";
        assertEquals(0, PatternIndex.patternIndex(subject, pattern));
    }

    @Test
    public void testPatternIndex3() throws Exception {
//TODO: Test goes here...
        String subject = "abc";
        String pattern = "abcd";
        assertEquals(-1, PatternIndex.patternIndex(subject, pattern));
    }

    @Test
    public void testPatternIndex4() throws Exception {
//TODO: Test goes here...
        String subject = "abc";
        String pattern = "de";
        assertEquals(-1, PatternIndex.patternIndex(subject, pattern));
    }


    // "xxx" and ""
    @Test (expected = StringIndexOutOfBoundsException.class)
    public void testPatternIndex5() throws Exception {
//TODO: Test goes here...
        String subject = "abc";
        String pattern = "";
        assertEquals(0, PatternIndex.patternIndex(subject, pattern));
    }

    // "xxx" and null
    @Test (expected = NullPointerException.class)
    public void testPatternIndex6() throws Exception {
//TODO: Test goes here...
        String subject = "abc";
        String pattern = null;
        assertEquals(0, PatternIndex.patternIndex(subject, pattern));
    }

    // null and "xxx"
    @Test (expected = NullPointerException.class)
    public void testPatternIndex7() throws Exception {
//TODO: Test goes here...
        String subject = null;
        String pattern = "abc";
        assertEquals(0, PatternIndex.patternIndex(subject, pattern));
    }

    // "" and "xxx"
    @Test
    public void testPatternIndex8() throws Exception {
//TODO: Test goes here...
        String subject = "";
        String pattern = "abc";
        assertEquals(-1, PatternIndex.patternIndex(subject, pattern));
    }

} 
