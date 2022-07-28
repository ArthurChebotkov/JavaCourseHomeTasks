import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter some string for checking Palindrom");
        String palindromCandidate = sc.next();

        int numberOfIteration = palindromCandidate.length()/2;

        boolean isPolindrom = true;

        for(int index=0; index < numberOfIteration && isPolindrom == true; index++) {
            if (palindromCandidate.charAt(index) != palindromCandidate.charAt(palindromCandidate.length() - index-1)) {
                isPolindrom = false;
            }
        }

        if (isPolindrom == true) {System.out.println("String '" + palindromCandidate + "' is a Polindrom!");}
        else {System.out.println("String '" + palindromCandidate + "' is not a Polindrom!");}

    }
}