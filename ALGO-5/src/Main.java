import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 49, 52);
        build(list);
    }

    public static void mark(List<Integer> ignoredList, int left, int right, int level, int[] levels) {
        if (left == right) {
            levels[left] = level;
            return;
        }
        int middle = (left + right) / 2;
        levels[middle] = level;
        mark(ignoredList, left, middle - 1, level + 1, levels);
        mark(ignoredList, middle + 1, right, level + 1, levels);
    }

    public static void build(List<Integer> list) {
        int[] levels = new int[list.size()];
        int max = 0;
        mark(list, 0, list.size() - 1, 0, levels);
        if (Arrays
                .stream(levels)
                .max()
                .isPresent()) {
            max = Arrays
                    .stream(levels)
                    .max()
                    .getAsInt();
        }
        for (int i = 0; i <= max + 1; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (levels[j] == i) {
                    System.out.print(list.get(j));
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
