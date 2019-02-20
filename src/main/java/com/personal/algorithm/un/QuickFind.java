package com.personal.algorithm.un;

/**
 * 动态连通性问题
 */
public class QuickFind {
    private int[] ids;
    private int count;

    public int find(int p) {
        return ids[p];
    }

    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) {
            return;
        }

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pid) {
                ids[i] = qid;
            }
        }
        count--;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
