import java.util.Arrays;
import java.util.Random;

public class Lottery {
    public static void main(String[] args) {
        Random rand = new Random();
        String[] numbers = args;
        String[] rands = new String[6];
        for (int i = 0; i < 6; i++) {
            rands[i] = String.valueOf(rand.nextInt(50));
        }
        for (int i = 0; i < 6; i++) {
            if (numbers[i].equals(rands[i])) {
                System.out.println("Won!!");
            }
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(rands));
    }
}