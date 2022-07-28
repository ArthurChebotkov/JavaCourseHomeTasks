import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String numberFromMachineString = getNumbersFromMachine(10000);

        Scanner sc = new Scanner(System.in);

        int bull = 0;
        int cow = 0;
        int bullForWin = 4;

        while (bull != bullForWin) {

            System.out.println("Enter 4 numbers");
            String numberFromUserString = sc.next();

            bull = 0;
            int cowWithBulls = 0;

            for (int index = 0; index < numberFromMachineString.length(); index++) {
                if (numberFromMachineString.charAt(index) == numberFromUserString.charAt(index)) {
                    bull++;
                }
                if (numberFromMachineString.contains(String.valueOf(numberFromUserString.charAt(index))) == true) {
                    cowWithBulls++;
                }
            }

            cow = cowWithBulls - bull;

            System.out.println("Bull = " + bull);
            System.out.println("Cow = " + cow);
        }
        System.out.println("You win!");
    }

    public static String getNumbersFromMachine (int bound) {
        Random random = new Random();
        int numberFromMachine = random.nextInt(bound);
        String numberFromMachineString = Integer.toString(numberFromMachine);

        System.out.println("*Secret* Number from machine = " + numberFromMachineString);

        return numberFromMachineString;
    }

}