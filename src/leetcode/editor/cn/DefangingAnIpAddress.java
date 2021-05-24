//给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。 
//
// 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。 
//
// 
//
// 示例 1： 
//
// 输入：address = "1.1.1.1"
//输出："1[.]1[.]1[.]1"
// 
//
// 示例 2： 
//
// 输入：address = "255.100.50.0"
//输出："255[.]100[.]50[.]0"
// 
//
// 
//
// 提示： 
//
// 
// 给出的 address 是一个有效的 IPv4 地址 
// 
// Related Topics 字符串 
// 👍 66 👎 0


package leetcode.editor.cn;

public class DefangingAnIpAddress {
  public static void main(String[] args) {
    Solution s = new DefangingAnIpAddress().new Solution();
    final String address = "192.168.4.11";
    System.out.println(s.defangIPaddr(address));
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String defangIPaddr(String address) {
        int len = address.length();
        // new char length
        int newLen = len + 3 * 2;
        char[] result = new char[newLen];
        int i = 0;
        for (char c : address.toCharArray()) {
            if (c != '.') {
                result[i++] = c;
            } else {
                result[i++] = '[';
                result[i++] = '.';
                result[i++] = ']';
            }
        }
        return new String(result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}