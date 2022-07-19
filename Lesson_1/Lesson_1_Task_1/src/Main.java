
public class Main {
    public static void main(String[] args) {

        System.out.println("Numbers from 1000 to 1 with step = 2");

        int start = 1000;
        int end = 1;
        int step = -2;
        for (int index = start; index > end; index += step) {
            System.out.println(index);
        }

    }
}