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

	// using an arraylist
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
        	return true;
        }
        ArrayList<Integer> nums = new ArrayList<>();
        ListNode n = head;
        while (n != null) {
        	nums.add(n.val);
        	n = n.next;
        }

        // System.out.println(nums);

        for (int i = 0; i < nums.size() / 2; i ++) {
        	if (!(nums.get(i).equals(nums.get(nums.size() - i - 1)))) {
        		return false;
        	}
        }
        return true;
    }
}