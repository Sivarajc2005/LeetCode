/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        Node dummy = new Node(-1);
        Node move = dummy;
        while(temp != null) {
            Node newTemp = new Node(temp.val);
            move.next = newTemp;

            map.put(temp, newTemp);

            temp = temp.next;
            move = move.next;
        }

        Node temp1 = head;
        Node move1 = dummy.next;
        while(temp1 != null) {
            if(temp1.random == null) {
                move1.random = null;
            } else {
                Node ext = map.get(temp1.random);
                move1.random = ext;
            }
            move1 = move1.next;
            temp1 = temp1.next;
        }

        return dummy.next;
    }
}