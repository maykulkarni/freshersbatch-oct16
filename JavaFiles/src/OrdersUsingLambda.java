import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by kulkarni_my on 10/27/2016.
 */
public class OrdersUsingLambda {
    public static void main(String[] args) {
        Predicate<Integer> priceMoreThanTenThousand = (Integer price) -> price > 10000;
        Predicate<String> orderStatus = (String status) -> status.equals("ACCEPTED");
        List<String> stringOrders = new ArrayList<>();
        stringOrders.add("ACCEPTED");
        stringOrders.add("REJECTED");
        stringOrders.add("ACCEPTED");
        stringOrders.add("REJECTED");
        stringOrders.add("ACCEPTED");

        List<String> answer = stringOrders
                .stream()
                .filter((x) -> x.equals("ACCEPTED"))
                .collect(Collectors.toList());
        answer.forEach(System.out::print);

    }
}
