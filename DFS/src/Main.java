// Алгоритм поиска в глубину на Java
import java.util.*;

class Graph {
    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    // Создание графа
    Graph(int vertices) {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();
    }

    // Добавление ребер
    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
    }

    // Алгоритм
    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> ite = adjLists[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = ite.next();
            if (!visited[adj])
                DFS(adj);
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(3, 4);

        System.out.println("Following is Depth First Traversal");

        g.DFS(2);
    }
}