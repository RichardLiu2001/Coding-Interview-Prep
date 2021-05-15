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
import java.util.*;

class Solution {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode prev = new ListNode();
		ListNode head = prev; 

		// add in order 
		while (l1 != null && l2 != null) {
			ListNode next = null; 

			if (l1.val < l2.val) {
				next = l1;
				l1 = l1.next;
			} else {
				next = l2;
				l2 = l2.next;
			}

			prev.next = next;
			prev = next;
		}

		if (l1 == null) {
			prev.next = l2;
		} else {
			prev.next = l1;
		}

		return head.next;
	}



	// put them in an array and sort
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ArrayList<Integer> vals = new ArrayList<>();
		ListNode n = l1;
		while (n != null) {
			vals.add(n.val);
			n = n.next;
		}
		n = l2;
		while (n != null) {
			vals.add(n.val);
			n = n.next;
		}
		Collections.sort(vals);
		System.out.println(vals);
		ListNode prev = new ListNode();
		ListNode head = prev;
		for (int val : vals) {
			ListNode a = new ListNode(val);
			prev.next = a;
			prev = a;
		}
		head = head.next;

		return head;

	}

}