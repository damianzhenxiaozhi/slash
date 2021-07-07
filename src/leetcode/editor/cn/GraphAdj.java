package leetcode.editor.cn;

import java.util.LinkedList;

/**
 * @author fanzhen
 * @version 1.0
 * @date 2021/7/7
 */
public class GraphAdj {
    private LinkedList<Integer>[] adj;

    public GraphAdj(int n) {
        adj = new LinkedList[n];
    }

    public void addSide(int s, int t) {
        addDirSide(s, t);
        addDirSide(t, s);
    }

    private void addDirSide(int s, int t) {
        if (adj[s] == null) {
            adj[s] = new LinkedList<>();
        }
        adj[s].add(t);
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }
}
