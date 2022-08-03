import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter with a space gift firstly Size Of Array and then Elements of Array");
        System.out.println("For example: '4 30 2 15 1'");

        int sizeOfArray = sc.nextInt();

        int array[] = new int[sizeOfArray];

        // Array input
        for(int i = 0; i<sizeOfArray; i++) {
            array[i] = sc.nextInt();
        }

        // Array output in reverse order
        for(int i = sizeOfArray-1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }


    }
}
