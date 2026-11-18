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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode oddTrav = odd;
        ListNode eveTrav = even;
        ListNode temp = head;
        boolean lastOdd = false;
        while(temp != null) {
            if(lastOdd) {
                eveTrav.next = temp;
                lastOdd = false;
                eveTrav = eveTrav.next;
                temp = temp.next;
                eveTrav.next = null;
            } else {
                lastOdd = true;
                oddTrav.next = temp;
                oddTrav = oddTrav.next;
                temp = temp.next;
                oddTrav.next = null;
            }
            
        }

        oddTrav.next = even.next;
        return odd.next;
    }
}