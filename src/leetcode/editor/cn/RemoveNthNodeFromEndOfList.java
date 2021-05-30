//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1389 👎 0


package leetcode.editor.cn;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution s = new RemoveNthNodeFromEndOfList().new Solution();
        MyList list = new MyList(new int[]{1,2,3,4,5});
        ListNode head = s.removeNthFromEnd(list.getHead(), 2);
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode p = head;
            while (n-- > 1) {
                p = p.next;
            }

            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode q = head;
            ListNode prevQ = dummy;
            while (p.next != null) {
                prevQ = q;
                q = q.next;
                p = p.next;
            }

            prevQ.next = q.next;

            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}