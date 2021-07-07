package leetcode.editor.cn;

/**
 * @author fanzhen
 * @version 1.0
 * @date 2021/7/7
 */
public class GraphMatrix {
    private boolean[][] matrix;

    public GraphMatrix(int n) {
        matrix = new boolean[n][n];
    }

    public void addSide(int s, int t) {
        matrix[s][t] = true;
        matrix[t][s] = true;
    }

    public boolean[][] getMatrix() {
        return matrix;
    }
}
