public ListNode findKthToLast(ListNode head, int k) {

	ListNode n = head;
	int listLength = 0; 
	while (n != null) {
		n = n.next;
		listLength ++;
	}

	n = head;
	for (int i = 0; i < listLength - k; i ++) {
		n = n.next;
	}

	return n;

}

public ListNode findKthToLast(ListNode head, int k ) {

	ListNode p1 = head;
	ListNode p2 = head; 

	for (int i = 0; i < k; i ++) {
		if (p1 == null) {
			return null;
		}
		p1 = p1.next;
	}

	// p2 is K nodes ahead of p1

	while (p1 != null) {
		p1 = p1.next;
		p2 = p2.next;
	}
	return p2; 

}