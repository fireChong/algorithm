package com.personal.algorithm.graph;

import java.util.ArrayList;

public class Graph {
    /**
     * 顶点数目
     */
    private final int v;

    /**
     * 边的数目
     */
    private int e;

    /**
     * 邻接表
     */
    private ArrayList<ArrayList<Integer>> adj;

    public Graph(int v) {
        this.v = v;
        this.e = 0;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public int v() {
        return v;
    }

    public int e() {
        return e;
    }

    public void addEage(int v1, int v2) {
        adj.get(v1).add(v2);
        adj.get(v2).add(v1);
        e++;
    }

    public Iterable<Integer> adj(int v) {
        return adj.get(v
        );
    }
}
