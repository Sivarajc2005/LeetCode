/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        return findMid(head);
    }
    
    boolean findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return isTrue(head , reverse(slow));
    }

    boolean isTrue(ListNode head , ListNode mid) {
        ListNode move1 = head;
        ListNode move2 = mid;
        while(move1 != null && move2 != null) {
            if(move1.val != move2.val) {
                return false;
            }
            move1 = move1.next;
            move2 = move2.next;
        }
        return true;
    }

    ListNode reverse(ListNode mid) {
        ListNode pre = null;
        ListNode curr = mid;
        while(curr != null) {
            ListNode store = curr.next;
            curr.next = pre;
            pre = curr;
            curr = store;
        }
        return pre;
    }
}