/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenl1 = 0;
        int lenl2 = 0;
        ListNode l1 = headA;
        ListNode l2 = headB;
        while(l1 != null) {
            l1 = l1.next;
            lenl1++;
        }
        while(l2 != null) {
            l2 = l2.next;
            lenl2++;
        }
        int tDistance = Math.abs(lenl1 - lenl2);
        l1 = headA;
        l2 = headB;
        if (lenl1 < lenl2) {
            for(int i = 0; i < tDistance; i++) {
                l2 = l2.next;
            }
        } else if (lenl1 > lenl2) {
            for(int i = 0; i < tDistance; i++) {
                l1 = l1.next;
            }
        }
        while(l1 != null && l2 != null) {
            if (l1 == l2) {
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }

}