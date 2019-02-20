package com.personal.algorithm.un;

/**
 * 动态连通性
 */
public class QuickUnion {
    private int[] ids;
    private int count;

    public int find(int p) {
        while (p != ids[p]){
            p = ids[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) {
            return;
        }

        ids[pid] = qid;
        count--;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
