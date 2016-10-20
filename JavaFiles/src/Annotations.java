/**
 * Created by kulkarni_my on 10/20/2016.
 */
public class Annotations {
    @Deprecated
    public static void printMe() {
        System.out.println("Hello this is annotations");
    }

    @SuppressWarnings(value = "Deprecated")
    public static void main(String[] args) {
        printMe();
    }
}
