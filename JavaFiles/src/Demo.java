import java.text.SimpleDateFormat;
public class Demo {
	public static void main(String[] args) {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date());
        System.out.println(date);
    }
}