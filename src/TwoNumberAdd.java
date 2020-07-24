import java.util.List;

/**
 * 题目：
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class TwoNumberAdd {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHeader = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode current = dummyHeader;
        int advance = 0;
        while (p != null || q != null){
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int value = x + y + advance;
            advance = value / 10;
            current.next = new ListNode(value % 10);
            current = current.next;
            if (p != null){
                p = p.next;
            }
            if (q != null){
                q = q.next;
            }

        }
        if (advance > 0){
            current.next = new ListNode(advance);
        }
        return dummyHeader.next;
    }

}
