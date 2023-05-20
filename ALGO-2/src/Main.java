import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static int n = 10;
    public static int c = 0;
    public static int l = 0;
    public static int u = 0;
    public static void main(String[] args) {

        String[][] field = {
                {"Щ", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "*", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "*", "-", "-", "-", "-"},
                {"*", "-", "*", "-", "-", "-", "*", "-", "-", "-"},
                {"*", "*", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "*", "-", "-", "*", "-", "-", "-", "*"},
                {"-", "*", "-", "-", "*", "-", "*", "-", "-", "*"},
                {"-", "*", "-", "-", "-", "-", "*", "*", "*", "-"},
                {"-", "-", "-", "-", "-", "-", "*", "-", "-", "-"},
                {"-", "-", "*", "-", "-", "-", "-", "-", "-", "-"},
        };
        findPath(field, 8, 3);
        System.out.println(c);
        System.out.println(l);
        System.out.println(u);
    }

    public static void findPath(String[][] field, int x0, int y0) {
        boolean[][] path = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(path[i], false);
        }
        String[][] memory = new String[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memory[i], "?");
        }
        int x = x0;
        int y = y0;
        while (!(x == 0 && y == 0)) {
            String direction = where_from(field, x, y, memory);
            if (Objects.equals(direction, "N")) {
                System.out.println("Нет такого пути :(");
                break;
            } else if (Objects.equals(direction, "U")) {
                path[x][y] = true;
                y -= 1;
            } else if (Objects.equals(direction, "L")) {
                path[x][y] = true;
                x -= 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == x0 && i == y0) {
                    System.out.print("Ч ");
                } else if (path[j][i]) {
                    System.out.print("x ");
                } else {
                    System.out.print(field[j][i] + " ");
                }
            }
            System.out.println();
        }
    }

    public static String where_from(String[][] field, int x, int y, String[][] memory) {
        c++;
        if (!Objects.equals(memory[x][y], "?")) return memory[x][y];
        if (x > 0) {
            int left_x = x - 1;
            int left_y = y;
            if (left_x == 0 && left_y == 0) {
                memory[x][y] = "L";
                return "L";
            }
            if (!Objects.equals(field[left_x][left_y], "*")) {
                if (!Objects.equals(where_from(field, left_x, left_y, memory), "N")) {
                    memory[x][y] = "L";
                    l++;
                    return "L";
                }
            }
        }
        if (y > 0) {
            int up_x = x;
            int up_y = y - 1;
            if (up_x == 0 && up_y == 0) {
                memory[x][y] = "U";
                return "U";
            }
            if (!Objects.equals(field[up_x][up_y], "*")) {
                if (!Objects.equals(where_from(field, up_x, up_y, memory), "N")) {
                    memory[x][y] = "U";
                    u++;
                    return "U";
                }
            }
        }
        memory[x][y] = "N";
        return "N";
    }
}