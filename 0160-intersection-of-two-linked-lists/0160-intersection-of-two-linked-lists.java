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
        ListNode tempA = headA;
        ListNode tempB = headB;

        int one = 0;
        int two = 0;

        while( tempA != null) {
            one++;
            tempA = tempA.next;
        }

        while(tempB != null) {
            two++;
            tempB = tempB.next;
        }

        int diff = Math.abs(one - two);

        ListNode large = one > two ? headA : headB;
        ListNode small = one > two ? headB : headA;

        for(int i = 0; i < diff; i++) {
            // System.out.print(large.val);
            large = large.next;
        }

        while(large != null && small != null) {
            if(large == small) {
                // System.out.print("point : "+ large.val + " then: "+ small.val);
                return large;
            }
            large = large.next;
            small = small.next;
        }
        return null;
    }
}