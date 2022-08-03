import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size of Array");
        int sizeOfArray = sc.nextInt();

        int array[] = new int[sizeOfArray];

        System.out.println("Enter with a space firstly Number for search and then " + sizeOfArray + " sorted elements of Array");
        System.out.println("For example: '4 1 34 110 220 500'");

        int keyNumber = sc.nextInt();

        // Array input
        for (int i = 0; i < sizeOfArray; i++) {
            array[i] = sc.nextInt();
        }

        // Found using method binarySearch
        boolean isKeyFound = binarySearch(array,keyNumber);

        // Results output
        if (isKeyFound) {
            System.out.println("Key number is found!");
        } else {
            System.out.println("There is not Key number in array!");
        }


    }

    public static boolean binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = arr[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return true;
        }
        return false;
    }

}