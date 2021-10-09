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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
    	// 1 2 3 4 5
    	// 1 
    	// 1 1 1 2345

    	ListNode prev = new ListNode();

    	ListNode head = prev;

    	// stop immediately once one of them are null
    	// append the rest of the other list (already sorted)
    	while (l1 != null && l2 != null) {

    		int l1val = l1.val;
    		int l2val = l2.val;

    		if (l1val < l2val) {
    			prev.next = l1;
    			l1 = l1.next;
    		} else {
    			prev.next = l2;
    			l2 = l2.next;
    		}

    		prev = prev.next;

    	}

    	if (l1 == null) {
    		prev.next = l2;
    	} 

    	if (l2 == null) {
    		prev.next = l1;
    	}

    	return head.next;








    }
}