import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter with a space gift Weight, Orange weight, Orange weight and Pear weight");
        System.out.println("For example: '200 30 2 15'");

        int weight = sc.nextInt();

        // Put fruits in array
        int[] fruitArray = new int[3];
        fruitArray[0] = sc.nextInt();
        fruitArray[1] = sc.nextInt();
        fruitArray[2] = sc.nextInt();

        // Sort the array
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < fruitArray.length-1; i++) {
                if(fruitArray[i] > fruitArray[i+1]){
                    isSorted = false;

                    buf = fruitArray[i];
                    fruitArray[i] = fruitArray[i+1];
                    fruitArray[i+1] = buf;
                }
            }
        }

        // Get max, middle and lower weight fruits
        int maxWeightFruit = fruitArray[2];
        int middleWeightFruit = fruitArray[1];
        int lowerWeightFruit = fruitArray[0];


        // Index means current count fruits in basket
        int indexMaxWeightFruit = 0;
        int indexMiddleWeightFruit;
        int indexLowerWeightFruit;

        int numberOfLoop = 0;

        while ((indexMaxWeightFruit  * maxWeightFruit) <= weight) {
            indexMiddleWeightFruit = 0;
            while ((indexMiddleWeightFruit * middleWeightFruit + indexMaxWeightFruit * maxWeightFruit) <= weight) {
                indexLowerWeightFruit = (weight - maxWeightFruit * indexMaxWeightFruit  - middleWeightFruit * indexMiddleWeightFruit) / lowerWeightFruit;
                System.out.println("Max weight fruit: " + indexMaxWeightFruit  + " Middle weight fruit: " + indexMiddleWeightFruit + " Lower weight fruit: " + indexLowerWeightFruit);
                numberOfLoop++;
                indexMiddleWeightFruit++;
            }
            indexMaxWeightFruit ++;
        }
        System.out.println("");
        System.out.println("--- Variants: " + numberOfLoop + " ---");
    }
}