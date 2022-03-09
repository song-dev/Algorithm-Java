package com.song.algorithm.graph;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 有向图
 */
public class DirectedGraph<T> {

    /**
     * 有向图顶点集合
     */
    public static class Vertex<T> {
        private final T data;
        private final int index;
        private final ArrayList<Edge<T>> edges = new ArrayList<>();
        private final boolean visited = false;

        public Vertex(T data, int index) {
            this.data = data;
            this.index = index;
        }

        public void addEdge(Edge<T> edge) {
            edges.add(edge);
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "data=" + data +
                    '}';
        }
    }

    public static class Edge<T> {

        private final Vertex<T> from;
        private final Vertex<T> to;
        private final double weight;

        public Edge(Vertex<T> from, Vertex<T> to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static class EdgeList<T> {
        private final Vertex<T> vertex;

        private final ArrayList<Edge<T>> edges = new ArrayList<>();

        public EdgeList(Vertex<T> vertex) {
            this.vertex = vertex;
        }

        public void addEdge(Edge<T> edge) {
            edges.add(edge);
        }
    }

    private final ArrayList<Vertex<T>> vertices = new ArrayList<>();
    private final ArrayList<EdgeList<T>> adjacencyList = new ArrayList<>();

    public Vertex<T> createVertex(T value) {
        for (Vertex<T> item : vertices) {
            if (item == value) {
                return item;
            }
        }
        Vertex<T> vertex = new Vertex<>(value, adjacencyList.size());
        vertices.add(vertex);
        adjacencyList.add(new EdgeList<>(vertex));
        return vertex;
    }

    public void addDirectedEdge(Vertex<T> fromVertex, Vertex<T> toVertex, double weightValue) {
        Edge<T> edge = new Edge<>(fromVertex, toVertex, weightValue);
        fromVertex.addEdge(edge);
        int fromIndex = vertices.indexOf(fromVertex);
        adjacencyList.get(fromIndex).edges.add(edge);
    }

    public void addUnDirectedEdge(Vertex<T> fromVertex, Vertex<T> toVertex, double weightValue) {
        addDirectedEdge(fromVertex, toVertex, weightValue);
        addDirectedEdge(toVertex, fromVertex, weightValue);
    }

    public void printAdjacencyList() {
        for (int i = 0; i < vertices.size(); i++) {
            if (!adjacencyList.get(i).edges.isEmpty()) {
                System.out.println(vertices.get(i).data + "->" + adjacencyList.get(i).edges.toString());
            }
        }
    }

    @Test
    public void test() {
        DirectedGraph<String> planeGraph = new DirectedGraph<>();
        Vertex<String> hk = planeGraph.createVertex("Hong Kong");
        Vertex<String> ny = planeGraph.createVertex("New York");
        Vertex<String> mosc = planeGraph.createVertex("Moscow");
        Vertex<String> ld = planeGraph.createVertex("London");
        Vertex<String> pairs = planeGraph.createVertex("Pairs");
        Vertex<String> am = planeGraph.createVertex("Amsterdam");
        Vertex<String> sf = planeGraph.createVertex("San Francisco");
        Vertex<String> ja = planeGraph.createVertex("Juneau Alaska");
        Vertex<String> tm = planeGraph.createVertex("Timbuktu");

        planeGraph.addUnDirectedEdge(hk, sf, 500.0);
        planeGraph.addUnDirectedEdge(hk, mosc, 900.0);
        planeGraph.addDirectedEdge(sf, ja, 300.0);
        planeGraph.addUnDirectedEdge(sf, ny, 150.0);
        planeGraph.addDirectedEdge(mosc, ny, 750.0);
        planeGraph.addDirectedEdge(ld, mosc, 200.0);
        planeGraph.addUnDirectedEdge(ld, pairs, 70.0);
        planeGraph.addDirectedEdge(sf, pairs, 800.0);
        planeGraph.addUnDirectedEdge(pairs, tm, 250.0);
        planeGraph.addDirectedEdge(am, pairs, 50.0);

        planeGraph.printAdjacencyList();
    }

    @Test
    public void test_dfs() {

    }

    @Test
    public void test_bfs() {

    }

}
