//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1168 👎 0


package leetcode.editor.cn;

public class SortList {
    public static void main(String[] args) {
        Solution s = new SortList().new Solution();
        MyList list = new MyList(new int[]{-1, 5, 3, 4, 0});
        ListNode head = s.sortList(list.getHead());
        MyList.print(head);
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode mid = getMid(head);

            ListNode firstHalf = sortList(head);
            ListNode secondHalf = sortList(mid);

            return mergeList(firstHalf, secondHalf);
        }

        private ListNode mergeList(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            ListNode tail = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    tail.next = l1;
                    tail = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    tail = l2;
                    l2 = l2.next;
                }
            }

            if (l1 != null) {
                tail.next = l1;
            }

            if (l2 != null) {
                tail.next = l2;
            }

            return dummy.next;
        }

        private ListNode getMid(ListNode head) {
            ListNode fast = head;
            ListNode preMid = null;

            while (fast != null && fast.next != null) {
                preMid = preMid == null ? head : preMid.next;
                fast = fast.next.next;
            }

            ListNode mid = preMid.next;
            preMid.next = null;

            return mid;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
