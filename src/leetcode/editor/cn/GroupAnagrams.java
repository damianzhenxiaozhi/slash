//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 760 👎 0


package leetcode.editor.cn;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution s = new GroupAnagrams().new Solution();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = s.groupAnagrams(strs);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();

            HashMap<String, List<String>> map = new HashMap<>();
            List<String> keys = new ArrayList<>();
            int n = strs.length;
            for (int i = 0; i < n; i++) {
                String key = sort(strs[i]);
                List<String> values = map.getOrDefault(key, new ArrayList<>());
                if (values.isEmpty()) {
                    keys.add(key);
                }
                values.add(strs[i]);
                map.put(key, values);
            }

            for (String key : keys) {
                result.add(map.get(key));
            }

            return result;
        }

        private String sort(String s) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);

            return new String(charArray);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}