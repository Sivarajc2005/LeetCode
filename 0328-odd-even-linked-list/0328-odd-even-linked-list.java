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
        ListNode temp = head;
        ListNode odd = new ListNode(0);
        ListNode eve = new ListNode(0);

        ListNode tempOdd = odd;
        ListNode tempEve = eve;

        Boolean isOdd = true;

        while(temp != null) {
            if(isOdd) {
                tempOdd.next = temp;
                tempOdd = tempOdd.next;
                isOdd = false;
                temp = temp.next;
                tempOdd.next = null;
                // System.out.println("Odd: ");
                // rec(odd);
            } else {
                tempEve.next = temp;
                tempEve = tempEve.next;
                isOdd = true;
                temp = temp.next;
                tempEve.next = null;
                // System.out.println("Even: ");
                // rec(eve);
            }
            
        }
        tempOdd.next = null;
        tempEve.next = null;
        // System.out.println("final sol: ");
        // rec(odd);
        // rec(eve);
        tempOdd.next = eve.next;
        // rec(odd);
        return odd.next;
    }

    public void rec(ListNode temp) {
        while(temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}