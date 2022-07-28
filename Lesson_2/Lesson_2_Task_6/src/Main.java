import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter package string");
        System.out.println("For example '22D7AC18FGD'");
        String packageString = sc.next();

        String[] letters = packageString.split("[0-9]+");
        String[] numbers = packageString.split("[A-Z]+");

        String stringFromChar = "";
        String unpackageString = "";
        int repeatCount = 0;
        String oneRepeatCount = "1";

        if(letters[0] == "") {
            for(int i=1;i<letters.length;i++) {
                stringFromChar = String.valueOf(letters[i].charAt(0));
                repeatCount = Integer.parseInt(numbers[i-1]);
                unpackageString = unpackageString + stringFromChar.repeat(repeatCount);
                int a = letters[i].length();
                for(int j=1;j<letters[i].length();j++) {
                    unpackageString += letters[i].charAt(j);
                }
            }
        }
        else {
            numbers[0] = oneRepeatCount;
            for(int i=0;i<letters.length;i++) {
                stringFromChar = String.valueOf(letters[i].charAt(0));
                repeatCount = Integer.parseInt(numbers[i]);
                unpackageString = unpackageString + stringFromChar.repeat(repeatCount);
                for(int j=1;j<letters[i].length();j++) {
                    unpackageString += letters[i].charAt(j);
                }
            }
        }
        System.out.println("Unpackage string:");
        System.out.println(unpackageString);
    }
}