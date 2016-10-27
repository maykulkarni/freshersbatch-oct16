/**
 * Created by kulkarni_my on 10/27/2016.
 */
public class MathOperationDemo {
    public static void main(String[] args) {
        MathOperations sum = (int x, int y) -> x + y;
        MathOperations subtract = (int x, int y) -> x - y;
        MathOperations divide = (int x, int y) -> x / y;
        MathOperations multiply = (int x, int y) -> x * y;
        doOperation(sum);
        doOperation(subtract);
        doOperation(multiply);
        doOperation(divide);
    }

    public static void doOperation(MathOperations mo) {
        int ans = mo.doOperation(4, 5);
        System.out.println(ans);
    }
}
