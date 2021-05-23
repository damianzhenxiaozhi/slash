//设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。 
//
// 以下是井字游戏的规则： 
//
// 
// 玩家轮流将字符放入空位（" "）中。 
// 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。 
// "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。 
// 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。 
// 当所有位置非空时，也算为游戏结束。 
// 如果游戏结束，玩家不允许再放置字符。 
// 
//
// 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "P
//ending"。 
//
// 示例 1： 
//
// 输入： board = ["O X"," XO","X O"]
//输出： "X"
// 
//
// 示例 2： 
//
// 输入： board = ["OOX","XXO","OXO"]
//输出： "Draw"
//解释： 没有玩家获胜且不存在空位
// 
//
// 示例 3： 
//
// 输入： board = ["OOX","XXO","OX "]
//输出： "Pending"
//解释： 没有玩家获胜且仍存在空位
// 
//
// 提示： 
//
// 
// 1 <= board.length == board[i].length <= 100 
// 输入一定遵循井字棋规则 
// 
// Related Topics 数组 
// 👍 21 👎 0


package leetcode.editor.cn;

public class TicTacToeLcci {
    public static void main(String[] args) {
        Solution s = new TicTacToeLcci().new Solution();
        String[] board = new String[]{"O X"," XO","X O"};
        System.out.println(s.tictactoe(board));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String tictactoe(String[] board) {
            int N = board.length;
            if (N == 0) return "Draw";

            // lines
            for (int i = 0; i < N; i++) {
                char c = board[i].charAt(0);
                if (c == ' ') continue;
                int j = 1;
                while (j < N && board[i].charAt(j) == c) {
                    j++;
                }
                if (j == N) return String.valueOf(c);
            }

            // columns
            for (int i = 0; i < N; i++) {
                char c = board[0].charAt(i);
                if (c == ' ') continue;
                int j = 1;
                while (j < N && board[j].charAt(i) == c) {
                    j++;
                }
                if (j == N) return String.valueOf(c);
            }

            // slash
            char c = board[0].charAt(0);
            if (c != ' ') {
                int i = 1;
                while (i < N && board[i].charAt(i) == c) {
                    i++;
                }

                if (i == N) return String.valueOf(c);
            }

            c = board[0].charAt(N - 1);
            if (c != ' ') {
                int i = 1;
                int j = N - 2;
                while (i < N && board[i].charAt(j) == c) {
                    i++;
                    j--;
                }

                if (i == N) return String.valueOf(c);
            }

            // draw or pending
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i].charAt(j) == ' ') {
                        return "Pending";
                    }
                }
            }

            return "Draw";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}