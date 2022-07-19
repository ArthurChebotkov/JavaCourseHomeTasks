import java.util.Scanner;

public class Main {// Класс нашей программы
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a six-digit number");
        String stringNumbers = sc.next();

        while (stringNumbers.length()!=6) {
            System.out.println("Isn't six-digit number! Try again");
            stringNumbers = sc.next();
        }

        char[] arrNumbers = stringNumbers.toCharArray();

        int sumFirstThree = 0;
        int sumSecondThree = 0;
        int maxDigit = 6;

        for (int index = 0; index< maxDigit; index ++) {
            if (index < 3) {
                sumFirstThree += Character.getNumericValue(arrNumbers[index]);
            }
            else {
                sumSecondThree += Character.getNumericValue(arrNumbers[index]);
            }
        }

        if (sumFirstThree == sumSecondThree) {
            System.out.println("You have a lucky numbers!");
        }
        else {
            System.out.println("Sorry! It isn't a lucky numbers!");
        }

    }
}
