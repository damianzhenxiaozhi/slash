package leetcode.editor.cn;

/**
 * @author fanzhen
 * @version 1.0
 * @date 2021/6/10
 */
public class GuessGame {
    private int n;
    private int pick;

    public GuessGame() {}

    public void set(int n, int pick) {
        this.n = n;
        this.pick = pick;
    }

    public int guess(int num) {
        if (num == pick) {
            return 0;
        } else if (num < pick) {
            return 1;
        } else {
            return -1;
        }
    }
}
