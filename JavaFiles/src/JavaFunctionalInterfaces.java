import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by kulkarni_my on 10/27/2016.
 */
public class JavaFunctionalInterfaces {
    public static void main(String[] args) {
        Supplier<Integer> random = () -> new Random().nextInt();
        Consumer<String> printMessage = System.out::println;
        Predicate<Integer> isGreaterThanThousand = (Integer x) -> x > 1000;
        Function<Integer, Long> intToLong = (Integer x) -> (long) x;

        List<String> myMessages = Arrays.asList("Hi", "this", "is", "a", "string");

        myMessages.forEach(printMessage);


    }

}
