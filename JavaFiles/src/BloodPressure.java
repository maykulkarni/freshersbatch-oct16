import java.util.Random;

/**
 * Created by kulkarni_my on 10/20/2016.
 */
public class BloodPressure {
    public static void check(int value) {
        if (value > 140) {
            System.out.println("BP is high : " + value);
        }
    }

    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        while (true) {
            Thread.sleep(1000);
            check(rand.nextInt(400));
        }
    }
}
