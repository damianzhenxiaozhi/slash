package leetcode.editor.cn;

/**
 * @author fanzhen
 * @version v1
 * @date 2021/5/28
 */
public class MyList {
    private ListNode head;
    private ListNode tail;
    private ListNode dummy;

    public MyList() {
        dummy = new ListNode();
        tail = dummy;
    }

    public MyList(int[] vals) {
        this();

        for (int val : vals) {
            insertAtTail3(val);
        }
    }

    public void insertAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtTail1(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }

        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }

        p.next = newNode;
    }

    public void insertAtTail2(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void insertAtTail3(int val) {
        head = dummy.next;

        ListNode newNode = new ListNode(val);

        tail.next = newNode;
        tail = newNode;
    }

    public void insertAfter(ListNode p, int val) {
        if (p == null) {
            return;
        }

        ListNode newNode = new ListNode(val, p.next);
        p.next = newNode;

        if (p == tail) {
            tail = newNode;
        }
    }

    public void insertBefore(ListNode p, int val) {
        if (p == null || head == null) {
            return;
        }

        ListNode prev = dummy;
        dummy.next = head;
        ListNode q = head;
        while (q != null && q != p) {
            prev = q;
            q = q.next;
        }

        if (q == null) {
            return;
        }

        prev.next = new ListNode(val, p);
        head = dummy.next;
    }

    public void deleteAfter(ListNode p) {
        if (p == null || p.next == null) {
            return;
        }

        if (p.next == tail) {
            tail = p;
        }
        p.next = p.next.next;
    }

    public void delete(ListNode p) {
        if (p == null || head == null) {
            return;
        }

        if (p == head) {
            head = head.next;

            if (p == tail) {
                tail = dummy;
            }
            return;
        }

        ListNode prev = dummy;
        dummy.next = head;
        ListNode q = head;
        while (q != null && q != p) {
            prev = q;
            q = q.next;
        }

        if (q == null) {
            return;
        }

        if (q == tail) {
            tail = prev;
        }
        prev.next = prev.next.next;
        head = dummy.next;
    }

    public void traverse() {
        print(head);
    }

    public ListNode find(int val) {
        ListNode p = head;
        while (p != null) {
            if (p.val == val) {
                return p;
            }
            p = p.next;
        }

        return null;
    }

    public ListNode getHead() {
        return head;
    }

    public ListNode getTail() {
        return tail;
    }

    public void addListAtTail(ListNode p) {
        ListNode q = p;
        while (q.next != null) {
            q = q.next;
        }

        tail.next = p;
        tail = q;
    }

    public void addListAtTail(MyList list) {
        tail.next = list.head;
        tail = list.tail;
    }

    public static void print(ListNode p) {
        System.out.print("[");
        while (p != null) {
            System.out.print(p.val + ",");
            p = p.next;
        }
        System.out.println("]");
    }
}
