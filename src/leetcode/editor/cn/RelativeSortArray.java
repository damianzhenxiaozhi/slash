//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组 
// 👍 177 👎 0


package leetcode.editor.cn;

import java.util.*;

public class RelativeSortArray {
    public static void main(String[] args) {
        Solution s = new RelativeSortArray().new Solution();
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        int[] result = s.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int n1 = arr1.length, n2 = arr2.length;

            // arr2 hash table
            Map<Integer, List<Integer>> valuePos = new HashMap<>();
            for (int i = 0; i < n2; i++) {
                valuePos.put(arr2[i], new ArrayList<>());
            }

            // loop arr1
            List<Integer> arr1Left = new ArrayList<>();
            for (int i = 0; i < n1; i++) {
                if (valuePos.containsKey(arr1[i])) {
                    valuePos.get(arr1[i]).add(i);
                } else {
                    arr1Left.add(arr1[i]);
                }
            }

            int[] result = new int[n1];
            int k = 0;
            // loop arr2
            for (int i = 0; i < n2; i++) {
                if (valuePos.containsKey(arr2[i])) {
                    for (int pos : valuePos.get(arr2[i])) {
                        result[k++] = arr1[pos];
                    }
                }
            }

            arr1Left.sort(Integer::compareTo);
            for (int i : arr1Left) {
                result[k++] = i;
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}