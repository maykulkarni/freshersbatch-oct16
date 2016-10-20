import java.lang.reflect.Method;

/**
 * Created by kulkarni_my on 10/20/2016.
 */
public class ReflectionAnnotation {

    public static void main(String[] args) throws Exception {
        Method[] methods = CustomAnnotation.class.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Getter.class)) {
                Getter annotation = method.getAnnotation(Getter.class);
                System.out.println(annotation.myName());

            }
        }
    }
}
