public void partition(ListNode head, int val) {
	if (head == null) {
		return;
	}

	ArrayList<Integer> lessThan = new ArrayList<>();
	ArrayList<Integer> greaterThan = new ArrayList<>();

	ListNode n = head;
	while (n != null) {
		int currentVal = n.val;
		if (currentVal < val) {
			lessThan.add(currentVal);
		} else {
			greaterThan.add(currentVal);
		}
		n = n.next;
	}

	n = head;
	for (int i = 0; i < lessThan.length(); i ++) {
		n.val = lessThan.get(i);
		n = n.next;
	}

	for (int i = 0; i < greaterThan.length(); i ++) {
		n.val = greaterThan.get(i);
		n = n.next;
	}

}

public void partition(ListNode n, int val) {
	ListNode head = n;
	ListNode tail = n;


	while (n != null) {
		if (n.val < val) {
			n.next = head;
			head = n;
		} else {
			tail.next = n;
			tail = n;
		}
		n = n.next;
	}

	return head;


}