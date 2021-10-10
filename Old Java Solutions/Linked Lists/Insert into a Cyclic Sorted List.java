class Solution {
	public Node insert(Node head, int insertVal) {

		if (head == null) {
			Node newNode = new Node(insertVal, null);
			newNode.next = newNode;
			return newNode;
		}

		Node prev = head;
		Node curr = head.next;
		boolean toInsert = false; 

		do {
			if (prev.val <= insertVal && insertVal <= curr.val) {
				// Case 1: Regular
				toInsert = true;
			} else if (prev.val > curr.val) {
				// case 2: val smaller or greater than all vals in list
				if (insertVal >= prev.val || insertVal <= curr.val) {
					toInsert = true;
				}
			}
			

			if (toInsert) {
				prev.next = new Node(insertVal, curr);
				return head; 
			}
			prev = curr;
			curr = curr.next;
		} while (prev != head);

	// case 3
		prev.next = new Node(insertVal, curr);
		return head; 
	}

}