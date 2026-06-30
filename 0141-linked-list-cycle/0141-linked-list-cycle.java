/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean first = true;
        while(fast != null && fast.next != null) {
            if(fast == slow && !first) {
                return true;
            }
            first = false;
            fast = fast.next.next;
            slow = slow.next;
        } 
        return false;
    }
}