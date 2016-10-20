import java.lang.reflect.Method;

/**
 * Created by kulkarni_my on 10/19/2016.
 */
public class Middleware {

    public static Object invokeMethod(String className, String methodName, Class[] paramTypes, Object[] paramValues) throws Exception {
        Class classObject = Class.forName(className);
        Object instance = classObject.newInstance();
        Method method = classObject.getDeclaredMethod(methodName, paramTypes);
        return method.invoke(instance, paramValues);
    }

    public static void main(String[] args) throws Exception {
        invokeMethod("Candy", "print", new Class[]{String.class}, new Object[]{"This is middleware"});
    }
}
