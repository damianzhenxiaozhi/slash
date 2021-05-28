//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 分治算法 
// 👍 120 👎 0


package leetcode.editor.cn;

public class HeBingLiangGePaiXuDeLianBiaoLcof {
    public static void main(String[] args) {
        Solution s = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
        int[] val1s = new int[]{1, 2, 4};
        int[] val2s = new int[]{1, 3, 4};
        MyList l1 = new MyList(val1s);
        MyList l2 = new MyList(val2s);
        ListNode mergeHead = s.mergeTwoLists(l1.getHead(), l2.getHead());
        MyList.print(mergeHead);
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }

            if (l2 == null) {
                return l1;
            }

            ListNode dummay = new ListNode();
            ListNode tail = dummay;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }

            if (l1 != null) {
                tail.next = l1;
            }

            if (l2 != null) {
                tail.next = l2;
            }

            return dummay.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}