import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kulkarni_my on 11/3/2016.
 */
public class GetCharTester {
    @org.junit.Test
    public void testConcatOne() {
        StringClassJUnit obj = new StringClassJUnit();
        assertEquals('a', obj.getChar("abcd", 0));
    }

    @Test
    public void testConcatTwo() {
        StringClassJUnit obj = new StringClassJUnit();
        assertEquals('a', obj.getChar("azxd", 0));
    }

    @Test
    public void testConcatThree() {
        StringClassJUnit obj = new StringClassJUnit();
        assertEquals('a', obj.getChar("artbb", 0));
    }
}
