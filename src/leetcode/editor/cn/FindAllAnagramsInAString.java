//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 104 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 572 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        String s  = "abab";
        String p = "ab";
        System.out.println(solution.findAnagrams(s, p));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            char[] cs = s.toCharArray();
            char[] cp = p.toCharArray();

            int[] htp = new int[26];
            for (char c : cp) {
                htp[c - 'a']++;
            }

            for (int i = 0; i < cs.length - cp.length + 1; i++) {
                if (isValid(cs, i, i + cp.length - 1, htp)) {
                    result.add(i);
                }
            }

            return result;
        }

        private boolean isValid(char[] cs, int i, int j, int[] htp) {
            int[] hts = new int[26];
            for (int k = i; k <= j; k++) {
                char c = cs[k];
                if (htp[c - 'a'] == 0) {
                    return false;
                }
                hts[c - 'a']++;
            }

            for (int k = 0; k < 26; k++) {
                if (hts[k] != htp[k]) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}