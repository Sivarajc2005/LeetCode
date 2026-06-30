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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode move = head;
        ListNode temp = new ListNode(-111);
        ListNode dummy = temp;
        while(move != null) {
            if (dummy.val != move.val) {
                dummy.next = move;
                dummy = dummy.next;
            }
            move = move.next;
        } 
        dummy.next = null;
        return temp.next;        
    }
}