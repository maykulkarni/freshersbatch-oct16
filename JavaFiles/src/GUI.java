import java.util.Scanner;

public class GUI {
    public static void main(String[] args) {
        String uname = "Mayur";
        String pass = "123";
        Scanner in = new Scanner(System.in);
        boolean kickUser = false;
        System.out.println("Enter username");
        in.next();
        int incorrectTries = 0;
        System.out.println("Enter password");
        while (true) {
            String curr = in.next();
            if (curr.equals(pass)) {
                System.out.println("Correct login!");
                break;
            } else {
                if (incorrectTries == 2) {
                    kickUser = true;
                    break;
                } else {
                    incorrectTries++;
                }
            }
        }
        if (kickUser) System.out.println("Contact Admin!");
    }
}