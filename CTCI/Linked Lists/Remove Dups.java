

public void removeDups(LinkedList head) {

	HashSet<Integer> nums = new HashSet<>();
	ListNode prev = null;
	while (head != null) {
		int currentVal = head.val;
		//first occurence of value
		if (!nums.contains(currentVal)) {
			nums.add(currentVal);
			prev = head;
		} else {
			prev.next = head.next;
		}
		head = head.next;
	}
}

public void removeDups(LinkedList head) {
	ListNode current = head;
	while (current != null) {

		int currentVal = current.val;

		ListNode runner = current;
		while (runner.next != null) {

			if (runner.next.val == currentVal) {
				runner.next = runner.next.next;
			} else {
				runner = runner.next;
			} 

		}

		current = current.next; 

	}


}