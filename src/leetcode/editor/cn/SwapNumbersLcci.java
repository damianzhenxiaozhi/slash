//编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。 
//
// 示例： 
//
// 
//输入: numbers = [1,2]
//输出: [2,1]
// 
//
// 提示： 
//
// 
// numbers.length == 2 
// -2147483647 <= numbers[i] <= 2147483647 
// 
// Related Topics 位运算 数学 
// 👍 54 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class SwapNumbersLcci {
    public static void main(String[] args) {
        Solution s = new SwapNumbersLcci().new Solution();
        int[] numbers = {1, 5};
        System.out.println(Arrays.toString(s.swapNumbers(numbers)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] swapNumbers(int[] numbers) {
            numbers[0] = numbers[0] ^ numbers[1];
            numbers[1] = numbers[0] ^ numbers[1];
            numbers[0] = numbers[0] ^ numbers[1];

            return numbers;
        }

        public int[] swapNumbers2(int[] numbers) {
            numbers[0] = numbers[0] + numbers[1];
            numbers[1] = numbers[0] - numbers[1];
            numbers[0] = numbers[0] - numbers[1];

            return numbers;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
