/**
 * Created by kulkarni_my on 10/20/2016.
 */
public class CustomAnnotation {
    public String name;

    public static void main(String[] args) {
        CustomAnnotation cs = new CustomAnnotation();
        cs.setName("Mayu");
        System.out.println(cs.getName());
    }

    @Getter(myName = "Mayur")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
