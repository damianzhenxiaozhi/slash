//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 字符串 动态规划 
// 👍 71 👎 0


package leetcode.editor.cn;

public class OneAwayLcci {
    public static void main(String[] args) {
        Solution s = new OneAwayLcci().new Solution();
        String first = "";
        String second = "a";
        System.out.println(s.oneEditAway(first, second));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean oneEditAway(String first, String second) {
            int firstLen = first.length();
            int secondLen = second.length();

            if (Math.abs(firstLen - secondLen) > 1) {
                return false;
            }


            if (firstLen == secondLen) {
                int replaceCount = 0;
                for (int i = 0; i < firstLen; i++) {
                    if (first.charAt(i) != second.charAt(i)) {
                        if (replaceCount > 0) {
                            return false;
                        } else {
                            replaceCount++;
                        }
                    }
                }

                return true;
            }


            String shorter = first;
            String longer = second;
            if (firstLen > secondLen) {
                shorter = second;
                longer = first;
            }

            int addCount = 0;
            int i = 0, j = 0;
            while (i < shorter.length() && j < longer.length()) {
                if (shorter.charAt(i) != longer.charAt(j)) {
                    if (addCount > 0) {
                        return false;
                    } else {
                        addCount++;
                        j++;
                    }
                } else {
                    i++;
                    j++;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}