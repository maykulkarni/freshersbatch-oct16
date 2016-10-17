public class Marks {
    public static void main(String[] args) {
        int markOne = Integer.parseInt(args[0]);
        int markTwo = Integer.parseInt(args[0]);
        int markThree = Integer.parseInt(args[0]);
        if (markOne > 60 && markTwo > 60 && markThree > 60) {
            System.out.println("Passed");
        } else if (markOne > 60 && markTwo > 60 || markTwo > 60 && markThree > 60 || markThree > 60 || markOne > 60) {
            System.out.println("Promoted");
        } else if ((markOne > 60 || markTwo > 60 || markThree > 60) || (markOne < 60 && markTwo < 60 && markThree < 60)) {
            System.out.println("Failed");
        }
    }
}