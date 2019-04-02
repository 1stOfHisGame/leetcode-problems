class MyLinkedList {

    public class Node{
        int val;
        Node next;
        public Node () {}
    }
    Node head;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        //print();
        Node target = head;
        for(int i=0; i<index; i++){
            if(target != null)
                target = target.next;
            else break;
        }   
        if(target == null) return -1;
        return target.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node curr = new Node();
        curr.val = val;
        curr.next = head;
        head = curr;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node curr = new Node();
        curr.val = val;
        Node target = head;
        if(head == null){
            head = curr;
            curr.next = null;
            return;
        }
        while(target.next != null){
            target = target.next;
        }
        if(target != null) target.next = curr;
        else head = curr;
        curr.next = null;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node curr = new Node();
        curr.val = val;
        if(index == 0){
            addAtHead(val);
            return;
        }
        Node target = head;
        for(int i=0; i<index-1; i++){
            if(target == null){
                return;
            }
            else target = target.next;
        }
        if(target == null) return; 
        curr.next = target.next;
        target.next = curr;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(head == null ){
            return;
        }
        if(index == 0){
            head = head.next;
            return;
        }
        Node target = head;
        for(int i=0; i<index-1; i++){
            if(target == null){
                return;
            }
            target = target.next;
        }
        
            if(target.next != null)
                target.next = target.next.next;
            else target.next = null;
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
