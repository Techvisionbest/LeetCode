
package two_pointer;
/**
 * @link leetCode:https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author vision
 * @since 2020/09/08
 */
public class DetectCycle {

    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode solution(ListNode head) {
        boolean hasCycle = false;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                hasCycle = true;
                break;
            }
        }

        slow = head;
        if (hasCycle){
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;

        }else {
            return null;
        }
    }
}
