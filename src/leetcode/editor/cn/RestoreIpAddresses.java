//给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯 
// 👍 612 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution s = new RestoreIpAddresses().new Solution();
        String ip = "010010";
        System.out.println(s.restoreIpAddresses(ip));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> result = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            char[] chars = s.toCharArray();

            backtrace(chars, 0, new ArrayList<>());

            return result;
        }

        private void backtrace(char[] chars, int k, List<String> path) {
            if (path.size() > 4) {
                return;
            }

            if (k == chars.length) {
                if (path.size() == 4) {
                    String s = path.stream().collect(Collectors.joining("."));
                    result.add(s);
                }
                return;
            }

            for (int i = k; i < chars.length; i++) {
                String s = new String(chars, k, i - k + 1);
                if (isValid(s)) {
                    path.add(s);
                    backtrace(chars, i + 1, path);
                    path.remove(path.size() - 1);
                }
            }
        }

        private boolean isValid(String s) {
            if (s.isEmpty()) {
                return false;
            }

            if (s.length() > 1 && s.charAt(0) == '0') {
                return false;
            }

            int i = 0;
            int value = 0;
            while (i < s.length()) {
                value = 10 * value + s.charAt(i) - '0';
                i++;
            }

            if (value < 0 || value > 255) {
                return false;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
