/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
    	if (head == null || head.next == null) {
    		return false; 
    	}

        ListNode slowRunner = head;
        ListNode fastRunner = head.next;

        while (fastRunner != null && fastRunner.next != null) {
        	if (slowRunner == fastRunner) {
        		return true;
        	}

        	slowRunner = slowRunner.next;
        	fastRunner = fastRunner.next.next;
        }
        return false; 
    }
}