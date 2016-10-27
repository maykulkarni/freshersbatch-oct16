import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Created by kulkarni_my on 10/27/2016.
 */
public class UnaryOperatorDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        UnaryOperator x;
        list.add("Mayur");
        list.add("bakayaro");
        list.add("uchiha");
        list.replaceAll((str) -> str.toUpperCase());
        System.out.println(list);
    }
}
