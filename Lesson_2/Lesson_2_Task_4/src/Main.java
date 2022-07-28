import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter some string with 0 and 1");
        System.out.println("For example: '00010101110'");
        String stringZeroAndOne = sc.next();

        int currentRep = 0;
        int maxRep = 0;

        for (int index = 0; index < stringZeroAndOne.length(); index++) {
            if (stringZeroAndOne.charAt(index) == '0') {
                currentRep++;
            }
            else if (stringZeroAndOne.charAt(index-1) != '1'){
                maxRep = Integer.max(maxRep, currentRep);
                currentRep = 0;
            }
            if (index == (stringZeroAndOne.length()-1)) {
                maxRep = Integer.max(maxRep, currentRep);
            }
        }

        System.out.println("Maximum number of consecutive '0': " + maxRep);
    }

}