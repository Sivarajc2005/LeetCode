/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        return rec(head);
    }

    public Node rec(Node head) {
        Node temp = head;
        
        while(temp != null) {
            // print(temp);
            if(temp.child != null) {
                Node bot = rec(temp.child);
                temp.child = null;
                Node save = temp.next;
                Node lastNodeOfSub = lastNode(bot);
                
                temp.next = bot;
                bot.prev = temp;
                lastNodeOfSub.next = save;
                if(save != null) 
                    save.prev = lastNodeOfSub;
                
                temp = save;
                
                // System.out.print("After the connect : ");
                // print(head);
            } else {
                temp = temp.next;
                // System.out.println(" emp ");
            }
        }
        
        return head;
    }
    
    public Node lastNode(Node head) {
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
    
    public void print(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.child + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }
}