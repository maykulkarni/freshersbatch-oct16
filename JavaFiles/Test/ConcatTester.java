import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by kulkarni_my on 11/3/2016.
 */
@RunWith(Parameterized.class)

public class ConcatTester {
    private String one;
    private String expected;
    private String two;

    public ConcatTester(String one, String two) {
        this.one = one;
        this.two = two;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList({{"onetwo"}, {"one", "two"}},
                {{"onz"}, {"one", "z"}});
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("This is calling before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("This is calling after class");
    }

    @Test
    public void paramCheck() {
        assertEquals(expected, new StringClassJUnit().concat(one, two));
    }

//    @Test
//    public void testConcatOne() {
//        StringClassJUnit obj = new StringClassJUnit();
//        assertEquals("onetwo", obj.concat("one", "two"));
//    }
//
//    @Test
//    public void testConcatTwo() {
//        StringClassJUnit obj = new StringClassJUnit();
//        assertEquals("threefour", obj.concat("three", "four"));
//    }
//
//    @Test
//    public void testConcatThree() {
//        StringClassJUnit obj = new StringClassJUnit();
//        assertEquals("fivesix", obj.concat("five", "six"));
//    }
}