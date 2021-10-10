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

	// Iterative solution
    public ListNode reverseList(ListNode head) {
        ListNode n = head;
        ListNode prev = null;
        ListNode next = null;
        while (n != null) {
            next = n.next;
            n.next = prev; 
            prev = n; 
            n = next;
        }
        return prev;
    }


	// recursive solution
	// dont really understand with return p
	public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}

}