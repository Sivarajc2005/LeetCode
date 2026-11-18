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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = reverse(head);
        if(n == 1) {
            return reverse(head.next);
        }
        ListNode temp = head;
        for(int i = 1; i < n - 1; i++) {
            temp = temp.next;
        }
        if(temp.next != null) {
            temp.next = temp.next.next;
        }
        
        return reverse(head);
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}