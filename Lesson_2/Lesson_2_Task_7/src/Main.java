import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter some text");
        String text = sc.nextLine();

        String[] wordsFromText = text.split(" ");

        HashMap<String, Integer> wordsAndCount = new HashMap<>();

        int currentCount = 1;

        for(int i = 0; i < wordsFromText.length; i++) {
            if (wordsAndCount.containsKey(wordsFromText[i]) == false) {
                for (int j = i+1; j < wordsFromText.length; j++) {
                    if(wordsFromText[i].equals(wordsFromText[j])) {
                        currentCount ++;
                    }
                }
                wordsAndCount.put(wordsFromText[i], currentCount);
                currentCount = 1;
            }
        }

        System.out.println("Information about words and counts:");
        System.out.println(wordsAndCount);

    }
}

