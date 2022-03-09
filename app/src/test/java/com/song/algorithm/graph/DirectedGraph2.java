package com.song.algorithm.graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 有向图
 * https://www.jianshu.com/p/48a14c00ab9c?utm_campaign=maleskine&utm_content=note&utm_medium=seo_notes&utm_source=recommendation
 */
public class DirectedGraph2<T> {

    /**
     * 顶点类
     */
    public static class Vertex<T> {
        private final T data;
        private final List<Edge<T>> edges = new ArrayList<>();
        private boolean visited = false;

        public Vertex(T data) {
            this.data = data;
        }

        public void addEdge(Edge<T> edge) {
            edges.add(edge);
        }
    }

    /**
     * 边类
     *
     * @param <T>
     */
    public static class Edge<T> {

        private final Vertex<T> targetVertex;
        private final int weight;

        public Edge(Vertex<T> to, int weight) {
            this.targetVertex = to;
            this.weight = weight;
        }
    }

    private final List<Vertex<T>> vertices = new ArrayList<>();

    public Vertex<T> createVertex(T value) {
        for (Vertex<T> item : vertices) {
            if (item == value) {
                return item;
            }
        }
        Vertex<T> vertex = new Vertex<>(value);
        vertices.add(vertex);
        return vertex;
    }

    public void addDirectedEdge(Vertex<T> fromVertex, Vertex<T> toVertex, int weightValue) {
        Edge<T> edge = new Edge<>(toVertex, weightValue);
        fromVertex.addEdge(edge);
    }

    public void addUnDirectedEdge(Vertex<T> fromVertex, Vertex<T> toVertex, int weightValue) {
        addDirectedEdge(fromVertex, toVertex, weightValue);
        addDirectedEdge(toVertex, fromVertex, weightValue);
    }

    /**
     * 深度优先搜索
     */
    public void depthFirstSearch() {
        dfsRecursive(vertices.get(0));
    }

    private void dfsRecursive(Vertex<T> vertex) {
        if (vertex != null) {
            System.out.println(vertex.data);
            vertex.visited = true;
            for (Edge<T> item : vertex.edges) {
                if (!item.targetVertex.visited) {
                    dfsRecursive(item.targetVertex);
                }
            }
        }
    }

    /**
     * 广度优先搜索
     */
    public void broadFirstSearch() {
        if (!vertices.isEmpty()) {
            Queue<Vertex<T>> queue = new LinkedList<>();
            queue.offer(vertices.get(0));
            while (!queue.isEmpty()) {
                Vertex<T> vertex = queue.poll();
                vertex.visited = true;
                System.out.println(vertex.data);
                for (Edge<T> item : vertex.edges) {
                    if (!item.targetVertex.visited) {
                        queue.offer(item.targetVertex);
                    }
                }
            }
        }
    }

    @Test
    public void test_dfs() {
        DirectedGraph2<Character> graph = new DirectedGraph2<>();
        Vertex<Character> aVertex = graph.createVertex('a');
        Vertex<Character> bVertex = graph.createVertex('b');
        Vertex<Character> cVertex = graph.createVertex('c');
        Vertex<Character> dVertex = graph.createVertex('d');
        Vertex<Character> eVertex = graph.createVertex('e');
        Vertex<Character> fVertex = graph.createVertex('f');
        Vertex<Character> gVertex = graph.createVertex('g');
        Vertex<Character> hVertex = graph.createVertex('h');
        Vertex<Character> iVertex = graph.createVertex('i');

        graph.addUnDirectedEdge(aVertex, gVertex, 5);
        graph.addUnDirectedEdge(aVertex, cVertex, 9);
        graph.addDirectedEdge(gVertex, hVertex, 3);
        graph.addUnDirectedEdge(gVertex, bVertex, 1);
        graph.addDirectedEdge(cVertex, bVertex, 7);
        graph.addDirectedEdge(dVertex, cVertex, 2);
        graph.addUnDirectedEdge(dVertex, eVertex, 7);
        graph.addDirectedEdge(gVertex, eVertex, 8);
        graph.addUnDirectedEdge(eVertex, iVertex, 2);
        graph.addDirectedEdge(fVertex, eVertex, 5);

        graph.depthFirstSearch();

    }

    @Test
    public void test_bfs() {

        DirectedGraph2<Character> graph = new DirectedGraph2<>();
        Vertex<Character> aVertex = graph.createVertex('a');
        Vertex<Character> bVertex = graph.createVertex('b');
        Vertex<Character> cVertex = graph.createVertex('c');
        Vertex<Character> dVertex = graph.createVertex('d');
        Vertex<Character> eVertex = graph.createVertex('e');
        Vertex<Character> fVertex = graph.createVertex('f');
        Vertex<Character> gVertex = graph.createVertex('g');
        Vertex<Character> hVertex = graph.createVertex('h');
        Vertex<Character> iVertex = graph.createVertex('i');

        graph.addUnDirectedEdge(aVertex, gVertex, 5);
        graph.addUnDirectedEdge(aVertex, cVertex, 9);
        graph.addDirectedEdge(gVertex, hVertex, 3);
        graph.addUnDirectedEdge(gVertex, bVertex, 1);
        graph.addDirectedEdge(cVertex, bVertex, 7);
        graph.addDirectedEdge(dVertex, cVertex, 2);
        graph.addUnDirectedEdge(dVertex, eVertex, 7);
        graph.addDirectedEdge(gVertex, eVertex, 8);
        graph.addUnDirectedEdge(eVertex, iVertex, 2);
        graph.addDirectedEdge(fVertex, eVertex, 5);

        graph.broadFirstSearch();
    }

}
