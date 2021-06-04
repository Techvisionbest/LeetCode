package daily;

import datastructure.ListNode;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class FindIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode dummyNodeA = headA;
        int index = 0;
        while (dummyNodeA != null){
            map.put(dummyNodeA, index);
            index++;
            dummyNodeA = dummyNodeA.next;
        }
        ListNode dummyNodeB = headB;
        while (dummyNodeB != null){
            if (map.containsKey(dummyNodeB)){
                return dummyNodeB;
            }
            dummyNodeB = dummyNodeB.next;
        }
        return null;
    }

    /**
     * 双指针
     * @param headA
     * @param headB
     * @return
     */
    public ListNode solution(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode indexA = headA, indexB = headB;
        while (indexA != indexB){
            indexA = indexA == null? headB : indexA.next;
            indexB = indexB == null? headA : indexB.next;
        }
        return indexA;
    }
}
