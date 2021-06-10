//稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。 
//
// 示例1: 
//
//  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""],
// s = "ta"
// 输出：-1
// 说明: 不存在返回-1。
// 
//
// 示例2: 
//
//  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], 
//s = "ball"
// 输出：4
// 
//
// 提示: 
//
// 
// words的长度在[1, 1000000]之间 
// 
// Related Topics 二分查找 
// 👍 49 👎 0


package leetcode.editor.cn;

public class SparseArraySearchLcci {
    public static void main(String[] args) {
        Solution s = new SparseArraySearchLcci().new Solution();
        String[] words = new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        String target = "ta";
        System.out.println(s.findString(words, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findString(String[] words, String s) {
            return findString(words, 0, words.length - 1, s);
        }

        private int findString(String[] words, int low, int high, String s) {
            if (low > high) {
                return -1;
            }

            int mid = low + (high - low) / 2;
            if (s.equals(words[mid])) {
                return mid;
            }

            if (words[mid].isEmpty()) {
                int left = findString(words, low, mid - 1, s);
                if (left != -1) {
                    return left;
                }
                return findString(words, mid + 1, high, s);
            }

            if (compare(words[mid], s) < 0) {
                return findString(words, mid + 1, high, s);
            } else {
                return findString(words, low, mid - 1, s);
            }
        }

        private int compare(String a, String b) {
            int len = Math.min(a.length(), b.length());

            for (int i = 0; i < len; i++) {
                if (a.charAt(i) < b.charAt(i)) {
                    return -1;
                } else if (a.charAt(i) > b.charAt(i)) {
                    return 1;
                }
            }

            return a.length() == b.length() ? 0 : (a.length() < b.length() ? -1 : 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
