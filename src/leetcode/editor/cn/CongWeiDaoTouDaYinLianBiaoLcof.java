//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 153 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution s = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        MyList list = new MyList(new int[]{1,3,2});
        int[] result = s.reversePrint(list.getHead());
        System.out.println(Arrays.toString(result));
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int[] reversePrint(ListNode head) {
            if (head == null) {
                return new int[0];
            }

            int[] tmp = reversePrint(head.next);
            int[] result = new int[tmp.length+1];
            System.arraycopy(tmp, 0, result, 0, tmp.length);
            result[tmp.length] = head.val;

            return result;
        }
    }

    class Solution1 {
        public int[] reversePrint(ListNode head) {
            if (head == null) {
                return new int[0];
            }

            List<Integer> vals = new ArrayList<>();

            ListNode newHead = null;
            ListNode p = head;
            while (p != null) {
                ListNode tmp = p.next;
                p.next = newHead;

                newHead = p;
                p = tmp;
            }

            p = newHead;
            while (p != null) {
                vals.add(p.val);
                p = p.next;
            }

            int[] result = new int[vals.size()];
            int i = 0;
            for (int val : vals) {
                result[i++] = val;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
