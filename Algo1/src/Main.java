import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Введите длину массива");
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < len; i++) {
            list.add((int) (Math.random() * 100));
        }
        System.out.println(list);
        int res = 0;
        for (int i = 1; i < len; i++) {
            res += list.get(i) - list.get(i-1);
        }
        System.out.println(res);
        System.out.println(list.get(len - 1) - list.get(0));
    }
}