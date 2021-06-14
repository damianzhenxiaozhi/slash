//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。 
//
// 示例 1： 
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true 
// 
//
// 示例 2： 
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
// 
//
// 说明： 
//
// 
// 0 <= len(s1) <= 100 
// 0 <= len(s2) <= 100 
// 
// Related Topics 数组 字符串 
// 👍 36 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutationLcci {
    public static void main(String[] args) {
        Solution s = new CheckPermutationLcci().new Solution();
        String s1 = "abc";
        String s2 = "bad";
        System.out.println(s.CheckPermutation(s1, s2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            Map<Character, Integer> charCount = new HashMap<>();

            for (char c : s1.toCharArray()) {
                if (charCount.containsKey(c)) {
                    int newCount = charCount.get(c) + 1;
                    charCount.put(c, newCount);
                } else {
                    charCount.put(c, 1);
                }
            }

            for (char c : s2.toCharArray()) {
                if (charCount.containsKey(c)) {
                    int newCount = charCount.get(c) - 1;
                    if (newCount == 0) {
                        charCount.remove(c);
                    } else {
                        charCount.put(c, newCount);
                    }
                } else {
                    return false;
                }
            }

            return charCount.size() == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}