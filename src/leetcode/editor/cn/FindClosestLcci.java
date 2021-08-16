//有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，
//你能对此优化吗? 
//
// 示例： 
//
// 输入：words = ["I","am","a","student","from","a","university","in","a","city"], 
//word1 = "a", word2 = "student"
//输出：1 
//
// 提示： 
//
// 
// words.length <= 100000 
// 
// Related Topics 数组 字符串 
// 👍 30 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindClosestLcci {
    public static void main(String[] args) {
        Solution s = new FindClosestLcci().new Solution();
        String[] words = {"I","am","a","student","from","a","university","in","a","city"};
        String word1 = "a";
        String word2 = "student";
        System.out.println(s.findClosest(words, word1, word2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findClosest(String[] words, String word1, String word2) {
            List<Integer> w1 = new ArrayList<>();
            List<Integer> w2 = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    w1.add(i);
                }
                if (words[i].equals(word2)) {
                    w2.add(i);
                }
            }

            int[] w1idx = new int[w1.size()];
            for (int i = 0; i < w1.size(); i++) {
                w1idx[i] = w1.get(i);
            }
            int[] w2idx = new int[w2.size()];
            for (int i = 0; i < w2.size(); i++) {
                w2idx[i] = w2.get(i);
            }

            Arrays.sort(w1idx);
            Arrays.sort(w2idx);

            int minDistance = Integer.MAX_VALUE;
            int i = 0, j = 0;
            while (i < w1idx.length && j < w2idx.length) {
                int diff = w1idx[i] - w2idx[j];
                if (diff == 0) {
                    return 0;
                } else if (diff > 0) {
                    j++;
                } else {
                    i++;
                }
                minDistance = Math.min(minDistance, Math.abs(diff));
            }

            return minDistance;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
