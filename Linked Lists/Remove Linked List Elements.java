class Solution {
  public ListNode removeElements(ListNode head, int val) {
    ListNode sentinel = new ListNode(0);
    sentinel.next = head;

    ListNode prev = sentinel, curr = head;
    while (curr != null) {
      if (curr.val == val) {
       prev.next = curr.next;
     } else {
      prev = prev.next;
    }
    curr = curr.next;
    
    }
    return sentinel.next;
  }
}