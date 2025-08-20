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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);

        for(ListNode temp : lists){  // taking the head 
           ListNode che = dummy;
           ListNode mover = temp;

            while(che != null && mover != null){   // hear over logic comes on 
                if(che.next == null){   //help joing the ll
                    che.next = mover; // is the mistake ?
                    break; 
                }
                else if(che.next.val > mover.val){
                    ListNode sperate = mover;
                    mover = mover.next;  // this move the pointer
                    sperate.next = che.next; //making the end connection 
                    che.next = sperate;  // making the fromt connection
                }
                
                che = che.next;  // ok we move pointer for every iteration 
            }
        }

        return dummy.next;   //i hoper this would work ..
    }
}