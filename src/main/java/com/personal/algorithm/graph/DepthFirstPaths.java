package com.personal.algorithm.graph;

import java.util.Stack;

/**
 * 使用深度优先搜索查找图中的路径
 */
public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    /**
     * 起点
     */
    private final int s;

    public DepthFirstPaths(Graph graph, int s) {
        marked = new boolean[graph.v()];
        edgeTo = new int[graph.v()];
        this.s = s;
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;

        Stack<Integer> path = new Stack<>();
        for (int i = v; i != s; i = edgeTo[i]) {
            path.push(i);
        }
        path.push(s);
        return path;
    }
}
