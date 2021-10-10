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

    // Using extra storage
    public ListNode detectCycle(ListNode head) {
    	ListNode n = head;
        if (head == null || head.next == null) {
            return null;
        }

        HashSet<ListNode> set = new HashSet<>();
        while (n != null) {
            if (!(set.add(n))) {
                return n;
            }
            n = n.next;
        }
        return null;
    }

    // Floyd's tortoise and hare algorithm
    public ListNode detectCycle(ListNode head) {

        ListNode intersection = getIntersect(head);
        if (intersection == null) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = intersection;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public ListNode getIntersect(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head; 
        ListNode intersection = null;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next; 
                hare = hare.next.next;
            if (hare == tortoise) {
                return hare;
            }
        }
        return null;
    }


}