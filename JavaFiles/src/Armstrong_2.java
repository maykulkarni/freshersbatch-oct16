public class Armstrong_2 {
    public static void main(String[] args) {
        for (int i = 100; i <= 999; i++) {
            int number = i;
            int num1 = number / 100;
            int num2 = (number / 10) % 10;
            int num3 = number % 10;
            if (Math.pow(num1, 3) + Math.pow(num2, 3) + Math.pow(num3, 3) == number) {
                System.out.println(number);
            }
        }
    }
}