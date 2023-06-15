import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        graph.addEdge(3, 4);
//        System.out.println(graph.adjacent(0));
//        System.out.println(graph.adjacent(1));
//        System.out.println(graph.adjacent(2));
        calcPaths(graph);

    }

    public static int dfs(Graph graph, int v, int mark, int[] marks) {
        marks[v] = mark;
        int size = 1;
        for (int vv : graph.adjacent(v)) {
            if (marks[vv] == 0) {
                size += dfs(graph, vv, mark, marks);
            }
        }
        return size;
    }

    public static void calcPaths(Graph graph) {
        int[] marks = new int[graph.v];
        ArrayList<Integer> markSizes = new ArrayList<>();
        int[] answer = new int[graph.v];
        for (int v = 0; v <= graph.v; v++) {
            if (marks[v] == 0) {
                int next_mark = markSizes.size();
                int size = dfs(graph, v, next_mark, marks);
                markSizes.add(size);
            }
            for (int i = 0; i <= graph.v; i++) {
                answer[i] = markSizes.get(marks[v]) - 1;
            }
        }
        for (int j : answer) {
            System.out.println(j);
        }

    }
}