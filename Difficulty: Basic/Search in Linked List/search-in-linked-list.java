/* Structure of Linked List Node
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}*/

class Solution {
    public boolean searchKey(Node head, int key) {
        // Code here
        Node current = head;
        
        while (current!=null){
            if (current.data==key){
                return true;
            }
            current=current.next;
        }
        return false;
    }
}