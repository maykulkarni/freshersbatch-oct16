import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int num1 = number / 100;
        int num2 = (number / 10) % 10;
        int num3 = number % 10;
        if (Math.pow(num1, 3) + Math.pow(num2, 3) + Math.pow(num3, 3) == number) {
            System.out.println("Armstrong number!");
        } else {
            System.out.println("Not Armstrong number");
        }
    }
}