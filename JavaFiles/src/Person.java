/**
 * Created by kulkarni_my on 10/26/2016.
 */
public class Person {
    String name;
    int weight;
    int height;

    public Person(String name, int weight, int height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
