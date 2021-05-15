class MyLinkedList {

    private int val;
    private ListNode head;


    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        int currentIndex = 0;
        ListNode n = head;
        while (currentIndex < index) {
            if (n == null) {
                return -1;
            }
            n = n.next;
            currentIndex ++;
        }
        return n.val; 

    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode n = new ListNode(val);
        n.next = head;
        head = n; 
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode n = head;
        if (n == null) {
            addAtHead(val);
        } else {
            while (n.next != null) {
                n = n.next;
            }

            ListNode add = new ListNode(val);
            n.next = add;
        }
        
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        } else {
            int currentIndex = 0;
            ListNode n = head;
            if (n == null) {
                return;
            }

            while (currentIndex < index) {
                if (n == null) {
                    return;
                }
                n = n.next;
                currentIndex ++;
            } 

            ListNode toAdd = new ListNode(val);
            toAdd.next = n.next;
            n.next = toAdd;
        }

    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode n = head;
        if (n == null) {
            return;
        }
        if (index == 0) {
            head = head.next; 
        }

        int currentIndex = 0;
        while (currentIndex < index - 1) {
            if (n == null) {
                return;
            }
            n = n.next;
            currentIndex ++;
        }
        if (n.next == null) {
            return;
        }
        n.next = n.next.next; 
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