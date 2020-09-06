package two_pointer;

import java.util.HashSet;

/**
 * @author vision
 * @link https://leetcode-cn.com/problems/linked-list-cycle/
 * @since 2020/09/07
 */
public class HasCycle {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 利用 HashSet
     *
     * @param head
     * @return
     */
//    private boolean solution(ListNode head) {
//        HashSet<ListNode> nodes = new HashSet<>();
//        ListNode current = head;
//        while (current != null){
//            if (nodes.contains(current)){
//                return true;
//            }else{
//                nodes.add(current);
//                current = current.next;
//            }
//        }
//        return false;
//    }


    private boolean solution(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
