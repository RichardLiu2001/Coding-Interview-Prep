/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = 0;
        int bLength = 0;

        if (headA == null || headB == null) {
        	return null;
        }

        ListNode longerList = headA;
        ListNode shorterList = headB;
        ListNode n = headA;
        while (n != null) {
        	n = n.next;
        	aLength ++;
        }

        n = headB;

        while (n != null) {
        	n = n.next;
        	bLength ++;
        }

        if (bLength > aLength) {
        	longerList = headB;
        	shorterList = headA;
        }

        for (int i = 0; i < Math.abs(aLength - bLength); i ++) {
        	longerList = longerList.next;
        }

        while (longerList != null && shorterList != null) {

        	if (longerList == shorterList) {
        		return longerList;
        	}

        	longerList = longerList.next;
        	shorterList = shorterList.next;

        }
        return null;

    }
}