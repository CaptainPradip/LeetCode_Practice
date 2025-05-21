/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1)) {
            return null;
        }

        //Brute Force Method

        //Reverse the list
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //prev is new head now
        ListNode newcurr = prev;
        ListNode newprev = null;
        int skip = 1;

        if (n == 1) {
            prev = prev.next; // Move head to the next node
        } else {
            while (skip < n) {
                skip++;
                newprev = newcurr;
                newcurr = newcurr.next;
            }
            newprev.next = newcurr.next;
        }

        ListNode newcurr2 = prev;
        ListNode newprev2 = null;
        ListNode newnext2 = null;
        while (newcurr2 != null) {
            newnext2 = newcurr2.next;
            newcurr2.next = newprev2;
            newprev2 = newcurr2;
            newcurr2 = newnext2;
        }
        return newprev2;

    }
}