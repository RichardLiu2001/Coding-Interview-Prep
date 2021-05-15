class Solution {

	public boolean isPalindrome(ListNode head) {

		Stack<Integer> numbers = new Stack<>();

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			numbers.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;

		}

		// skip the middle element if there is an odd number of elements
		if (fast != null) {
			slow = slow.next;
		}

		

	}

	public boolean isPalindrome(ListNode node) {

		LinkedList reversed = getReverse(node);

		// iterate through each list and check if vals are different
		while (node != null && reversed != null) {
			if (node.val != reversed.val) {
				return false;
			}
			node = node.next;
			reversed = reversed.next;
		}	

		// both should be null, if not then lists are different lengths and return false. 
		return node == null && reversed == null;

	}

	public ListNode getReverse(ListNode node) {

		ListNode head = null;
		while (node != null) {
			// assign rest of created list after current node, hence going backwards
			ListNode n = new ListNode(node.val);
			n.next = head;
			n = head;

			node = node.next;
		}

		return head; 

	}




}