import java.lang.reflect.Constructor;

/**
 * Created by kulkarni_my on 10/19/2016.
 */
public class InstantiateClass {
    public static void main(String[] args) throws Exception {
        String className = args[0];
        Class c = Class.forName(className);
        Object obj = c.newInstance();
        Constructor cst = c.getConstructor(String.class);
        Object newObj = cst.newInstance("This is a parametrized constructor");
        System.out.println(obj.getClass());
        System.out.println(newObj.toString());
    }
}
