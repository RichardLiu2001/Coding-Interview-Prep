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
        
        ListNode currentl1 = l1;
        ListNode currentl2 = l2;

        int carry = 0;

        ListNode result = new ListNode();

        ListNode prev = result;

        while (currentl1 != null || currentl2 != null) {

        	int l1Val = currentl1 == null ? 0 : currentl1.val;
        	int l2Val = currentl2 == null ? 0 : currentl2.val;

        	int sum = l1Val + l2Val + carry;

        	int digit = sum % 10;
        	carry = sum / 10;

        	ListNode toAdd = new ListNode(digit);
        	prev.next = toAdd;

        	prev = toAdd;

        	if (currentl1 != null) {
        		currentl1 = currentl1.next;

        	}
        	if (currentl2 != null) {
        		currentl2 = currentl2.next;

        	}
        	

        }

        if (carry > 0) {
        	ListNode toAdd = new ListNode(carry);
        	prev.next = toAdd;
        }

        return result.next;

        // result 
        // prev -> 1 -> 2 -> 3

        // 99 + 99
        // 19832524
        // 99 + 99 


    }
}