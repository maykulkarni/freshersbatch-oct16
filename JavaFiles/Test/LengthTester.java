import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kulkarni_my on 11/3/2016.
 */
public class LengthTester {
    @org.junit.Test
    public void testConcatOne() {
        StringClassJUnit obj = new StringClassJUnit();
        assertEquals(3, obj.length("one"));
    }

    @Test
    public void testConcatTwo() {
        StringClassJUnit obj = new StringClassJUnit();
        assertEquals(5, obj.length("three"));
    }

    @Test
    public void testConcatThree() {
        StringClassJUnit obj = new StringClassJUnit();
        assertEquals(5, obj.length("qwert"));
    }
}
