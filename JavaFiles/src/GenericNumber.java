import java.util.ArrayList;
import java.util.List;

/**
 * Created by kulkarni_my on 10/27/2016.
 */
public class GenericNumber<T extends Number> {
    T numericData;

    public GenericNumber(T numericData) {
        this.numericData = numericData;
    }

    public T getNumericData() {
        return numericData;
    }

    @Override
    public String toString() {
        return this.numericData.toString() + "\n";
    }
}

class GenericNumberDemo {
    public static void main(String[] args) {
        List<GenericNumber> list = new ArrayList<>();
        list.add(new GenericNumber(2.33));
        list.add(new GenericNumber(24783));
        list.add(new GenericNumber(2243243247832947L));
        System.out.println(list);
    }
}