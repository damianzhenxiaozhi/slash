//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 
// 👍 1377 👎 0


package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution s = new LetterCombinationsOfAPhoneNumber().new Solution();
        String digit = "";
        System.out.println(s.letterCombinations(digit));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final Map<Character, List<String>> digitalToAlpha = new HashMap<>();
        private List<List<String>> paths = new ArrayList<>();

        public Solution() {
            digitalToAlpha.put('2', new ArrayList<>(Arrays.asList("a", "b", "c")));
            digitalToAlpha.put('3', new ArrayList<>(Arrays.asList("d", "e", "f")));
            digitalToAlpha.put('4', new ArrayList<>(Arrays.asList("g", "h", "i")));
            digitalToAlpha.put('5', new ArrayList<>(Arrays.asList("j", "k", "l")));
            digitalToAlpha.put('6', new ArrayList<>(Arrays.asList("m", "n", "o")));
            digitalToAlpha.put('7', new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
            digitalToAlpha.put('8', new ArrayList<>(Arrays.asList("t", "u", "v")));
            digitalToAlpha.put('9', new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
        }

        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) {
                return Collections.emptyList();
            }

            char[] numbers = digits.toCharArray();
            backTrace(getSelected(numbers[0]), 0, numbers, numbers.length, new ArrayList<>());

            List<String> result = new ArrayList<>();
            for (List<String> path : paths) {
                result.add(path.stream().collect(Collectors.joining()));
            }

            return result;
        }

        private void backTrace(List<String> selected, int k, char[] numbers, int n, List<String> path) {
            if (k >= n) {
                paths.add(new ArrayList<>(path));
                return;
            }

            for (String s : selected) {
                path.add(s);

                backTrace(k >= n- 1 ? Collections.emptyList() : getSelected(numbers[k + 1]), k + 1, numbers, n, path);

                path.remove(path.size() - 1);
            }
        }

        private List<String> getSelected(char c) {
            return digitalToAlpha.get(c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
