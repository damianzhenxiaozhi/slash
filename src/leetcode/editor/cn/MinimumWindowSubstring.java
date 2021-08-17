//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 
// 👍 1289 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution.minWindow(s, t));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            int i = 0, j = 0;
            int minLen = Integer.MAX_VALUE;
            String minSubStr = "";
            Map<Character, Integer> winMap = new HashMap<>();
            while (j <= s.length()) {
                if (isContain(winMap, map)) {
                    if (j - i  < minLen) {
                        minLen = j - i;
                        minSubStr = s.substring(i, j);
                    }
                    if (i < j) {
                        char c = s.charAt(i);
                        int count = winMap.get(c);
                        winMap.put(c, count - 1);
                        i++;
                    }
                } else {
                    if (j < s.length()) {
                        char c = s.charAt(j);
                        winMap.put(c, winMap.getOrDefault(c, 0) + 1);
                    }
                    j++;
                }
            }

            return minSubStr;
        }

        private boolean isContain(Map<Character, Integer> winMap, Map<Character, Integer> map) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (!winMap.containsKey(entry.getKey())) {
                    return false;
                }

                int count = winMap.get(entry.getKey());
                if (count < entry.getValue()) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
