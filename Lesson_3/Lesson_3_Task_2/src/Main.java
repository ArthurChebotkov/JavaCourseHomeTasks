import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter with a space firstly Size Of Array and then Elements of Array");
        System.out.println("For example: '4 30 2 15 1'");

        int sizeOfArray = sc.nextInt();

        int array[] = new int[sizeOfArray];

        // Array input
        for (int i = 0; i < sizeOfArray; i++) {
            array[i] = sc.nextInt();
        }

        //Bubble Sorting
        int buf;
        for (int out = sizeOfArray - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(array[in] > array[in + 1]) {
                    buf = array[in];
                    array[in] = array[in+1];
                    array[in+1] = buf;
                }
            }
        }

        // Sorted array output
        arrayPrinter(array);

    }
    public static void arrayPrinter(int array[]) {
        System.out.println("Sorted array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}