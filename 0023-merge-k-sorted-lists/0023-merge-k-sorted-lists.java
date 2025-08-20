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
    public ListNode mergeKLists(ListNode[] lists) { //parameter is lists

        ArrayList<ListNode> list = new ArrayList<>(); // we using the list

        for(ListNode temp : lists){
            while(temp != null){
                ListNode sp = temp; // we sperating the hands
                temp = temp.next; // moving the pointer
                sp.next = null; // cutting the hands 
                list.add(sp);
            }
        } 

        Collections.sort(list , (a , b) -> Integer.compare(a.val , b.val)); //custome sorting help us 

        ListNode dummy = new ListNode(0);
        ListNode mov = dummy; //this the mover
        for(ListNode temp : list){
            // System.out.print(temp.val +" -> "); //see it printing the correct order that good 
            
            //now make them as chain 
            mov.next = temp;
            mov = mov.next;  
        }

        return dummy.next;
    }
}