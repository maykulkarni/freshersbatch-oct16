/**
 * Created by kulkarni_my on 10/27/2016.
 */
public class GenericWrapper<T> {
    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

class Demos {
    public static void main(String[] args) {
        GenericWrapper<String> wrpr = new GenericWrapper<>();
        wrpr.setData("My data");
        System.out.println(wrpr.getData());
    }
}