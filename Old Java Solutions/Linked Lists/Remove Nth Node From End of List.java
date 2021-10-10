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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if (head == null) {
        	return null;
        }
    	ListNode back = head;
    	ListNode front = head;
    	ListNode beforeFront = head;

    	for (int i = 0; i < n; i ++) {
    		back = back.next;
    	}	


    	while (back != null) {
    		back = back.next;
    		if (back != null) {
    			beforeFront = beforeFront.next; 
    		}
    		front = front.next;

    	}

    	if (front == head) {
    		head = front.next;
    	} else {
    		beforeFront.next = beforeFront.next.next; 
    	}

    	return head; 

    }
}