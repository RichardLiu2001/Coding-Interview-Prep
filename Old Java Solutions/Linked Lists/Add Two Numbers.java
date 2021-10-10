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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode();
        ListNode head = prev;
        int carry = 0;

        while (carry > 0 || l1 != null || l2 != null) {
            
        	int v1 = 0;
            int v2 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            
        	int sum = v1 + v2 + carry;
        	carry = sum / 10;
        	int digit = sum % 10;
        	ListNode n = new ListNode(digit);
        	prev.next = n;
        	prev = prev.next;
        }

        if (carry > 0) {
        	prev.next = new ListNode(carry);
        }


        return head.next;
    }
}