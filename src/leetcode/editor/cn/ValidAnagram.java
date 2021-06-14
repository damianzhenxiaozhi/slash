//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 393 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        Solution s1 = new ValidAnagram().new Solution();
        String a = "rat";
        String b = "car";
        System.out.println(s1.isAnagram(a, b));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            Map<Character, Integer> charCount = new HashMap<>();

            for (char c : s.toCharArray()) {
                if (charCount.containsKey(c)) {
                    int newCount = charCount.get(c) + 1;
                    charCount.put(c, newCount);
                } else {
                    charCount.put(c, 1);
                }
            }

            for (char c : t.toCharArray()) {
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

        public boolean isAnagram2(String s, String t) {
            char[] a = s.toCharArray();
            char[] b = t.toCharArray();

            mergeSort(a, 0, a.length-1);
            mergeSort(b, 0, b.length-1);

            return Arrays.equals(a, b);
        }

        private void insertSort(char[] a, int n) {
            for (int i = 1; i < n; i++) {
                int j = i - 1;
                char tmp = a[i];
                while (j >= 0) {
                    if (a[j] > tmp) {
                        a[j + 1] = a[j];
                        j--;
                    } else {
                        break;
                    }
                }

                a[j + 1] = tmp;
            }
        }

        private void mergeSort(char[] a, int p, int q) {
            if (p >= q) {
                return;
            }

            int r = p + (q - p) / 2;

            mergeSort(a, p, r);
            mergeSort(a, r + 1, q);

            merge(a, p, r, q);
        }

        private void merge(char[] a, int p, int r, int q) {
            char[] tmp = new char[q - p + 1];
            int i = p, j = r + 1, k = 0;
            while (i <= r && j <= q) {
                if (a[i] <= a[j]) {
                    tmp[k++] = a[i++];
                } else {
                    tmp[k++] = a[j++];
                }
            }

            while (i <= r) {
                tmp[k++] = a[i++];
            }

            while (j <= q) {
                tmp[k++] = a[j++];
            }

            for (k = 0; k < q - p + 1; k++) {
                a[p + k] = tmp[k];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
