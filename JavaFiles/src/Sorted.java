import java.util.Arrays;

public class Sorted {
    public static void main(String[] args) {
        int[] z = new int[args.length];
        int i = 0;
        for (String a : args) {
            try {
                z[i++] = Integer.parseInt(a);
            } catch (Exception e) {
                System.out.println("Cant be parsed");
            }
        }

        for (int x = 0; x < z.length - 1; x++) {
            for (int j = 0; j < z.length - 1; j++) {
                if (z[j] > z[j + 1]) {
                    int temp = z[j];
                    z[j] = z[j + 1];
                    z[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(z));
    }
}