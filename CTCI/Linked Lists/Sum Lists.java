public LinkedList sumList(LinkedList l1, LinkedList l2) {

	if (l1 == null) {
		return l2;
	}

	if (l2 == null) {
		return l1;
	}

	ListNode n1 = l1;
	ListNode n2 = l2;


	ListNode head = new ListNode();
	ListNode last = head;


	int carry = 0;
	boolean first = true;

	while (n1 != null || n2 != null) {

		int n1Val = 0;
		int n2Val = 0;

		if (n1 != null) {
			n1Val = n1.val;
		}

		if (n2 != null) {
			n2Val = n2.val;
		}

		int sum = n1Val + n2Val + carry;

		ListNode toAdd = new ListNode(sum % 10);
		carry = sum / 10;
		if (first) {
			head = toAdd;
			last = head;
		} else {
			last.next = toAdd;
			last = toAdd;
		}

		if (n1 != null) {
			n1 = n1.next;

		}
		if (n2 != null) {
			n2 = n2.next;

		}

	}
	return head; 


}

public LinkedList sumList(ListNode l1, ListNode l2) {

	return sumHelp(l1, l2, 0)
}

public ListNode sumHelp(ListNode l1, ListNode l2, int carry) {
	// base case, reached end of both lists, return null to indicate end of result list
	if (l1 == null && l2 == null && carry == 0) {
		return null;
	}
	int sum = carry;
	if (l1 != null) {
		sum += l1.val;
	}

	if (l2 != null) {
		sum += l2.val;
	}

	ListNode result = new ListNode(sum % 10)
	carry = sum / 10; 
	// if either list still has numbers, we need to recurse
	if (l1 != null || l2 != null) {
		result.next = sumHelp(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry)
	}
	return result; 
	
}





