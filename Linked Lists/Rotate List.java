class Solution {
	public ListNode rotateRight(ListNode head, int k) {

		if (head == null || head.next == null) {
			return head; 
		}

		ListNode n = head;
		int size = 1;
		while (n.next != null) {
			size ++;
			n = n.next;
		}
		int advance = k % size;
		System.out.println("advance: " + advance);
		System.out.println("size: " + size);
		System.out.println("tail: " + n.val);
		ListNode tail = n;
		tail.next = head;
		System.out.println("head: " + head.val);
		for (int i = 0; i < advance; i ++) {
			System.out.println("current tail: " + tail.val);
			tail = tail.next;
			System.out.println("current head: " + head.val);
			head = head.next;
		}
		System.out.println("final tail: " + tail.val);
		System.out.println("final head: " + head.val);
		tail.next = null;
		return head; 

	}

}