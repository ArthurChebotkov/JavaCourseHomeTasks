import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner scStop = new Scanner(System.in);

        String stop = "";
        String stopWord = "stop";

        do {

            System.out.println("Enter first number");
            int firstNumber = sc.nextInt();

            System.out.println("Enter second number");
            int secondNumber = sc.nextInt();

            System.out.println("Enter operator [+], [-], [*], [/]");
            String operator = sc.next();

            System.out.println("Result:");
            switch (operator) {
                case "+":
                    System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " +
                            (firstNumber+secondNumber));
                    break;
                case "-":
                    System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " +
                            (firstNumber-secondNumber));
                    break;
                case "*":
                    System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " +
                            firstNumber*secondNumber);
                    break;
                case "/":
                    float resultOfDivision = (float) firstNumber/secondNumber;
                    System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " +
                            resultOfDivision);
                    break;
                default:
                    System.out.println("Error: the entered operator doesn't match");
                    break;
            }

            System.out.println("");

            System.out.println("Enter any symbol or 'stop' if you want break");
            stop = scStop.nextLine();

            System.out.println("");

        } while (!stop.equals(stopWord));

    }
}
