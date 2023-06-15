
import java.util.ArrayList;

public class Graph {
    public int v;
    public ArrayList<ArrayList<Integer>> verticesInfo = new ArrayList<>();

    public Graph(int v) {
        this.v = v;
        for (int i = 0; i < v; i++) {
            verticesInfo.add(gerArray());
        }
    }

    public ArrayList<Integer> gerArray() {
        return new ArrayList<Integer>();
    }

    public void addEdge(int a, int b) {
        verticesInfo.get(a).add(b);
        verticesInfo.get(b).add(a);
    }

    public ArrayList<Integer> adjacent(int v) {
        return verticesInfo.get(v);
    }

    public int size() {
        return v;
    }
}