import java.lang.reflect.Field;

/**
 * Created by kulkarni_my on 10/19/2016.
 */
public class AccessPrivateFields {
    public static void main(String[] args) throws Exception {
        Class c = Class.forName("Candy");
        Field field = c.getDeclaredField("somePrivateValue");
        field.setAccessible(true);
        System.out.println(field.get(new Candy()));
    }

}
