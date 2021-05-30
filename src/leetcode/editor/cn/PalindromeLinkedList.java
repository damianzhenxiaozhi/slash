//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 989 👎 0


package leetcode.editor.cn;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution s = new PalindromeLinkedList().new Solution();
        MyList l = new MyList(new int[]{1});
        System.out.println(s.isPalindrome(l.getHead()));
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
        public boolean isPalindrome(ListNode head) {
            int N = lenOfList(head);

            if (N <= 1) {
                return true;
            }

            int n = N / 2;
            ListNode prev = null;
            ListNode p = head;
            ListNode q = head;
            while (n-- > 0) {
                q = p.next;
                p.next = prev;

                prev = p;
                p = q;
            }

            if (N % 2 != 0) {
                q = q.next;
            }

            p = prev;
            while (p != null && q != null) {
                if (p.val != q.val) {
                    return false;
                }
                p = p.next;
                q = q.next;
            }

            return true;
        }

        private int lenOfList(ListNode head) {
            ListNode p = head;
            int len = 0;
            while (p != null) {
                len++;
                p = p.next;
            }

            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}