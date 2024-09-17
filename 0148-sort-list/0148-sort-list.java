/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        // 1. use sorting algoritham

        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    // [-1,5,3,4,0]

    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevNode = null;
        while (fast != null && fast.next != null) {
            prevNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prevNode!=null)
            prevNode.next = null;
        return slow;
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode trav1 = left;
        ListNode trav2 = right;
        ListNode head = new ListNode(0);
        ListNode trav = head;
        while (trav1 != null && trav2 != null) {
            if (trav1.val < trav2.val) {
                trav.next = trav1;
                trav1 = trav1.next;
            } else {
                trav.next = trav2;
                trav2 = trav2.next;
            }
            trav = trav.next;
        }
        while (trav1 != null) {
            trav.next = new ListNode(trav1.val);
             trav =  trav.next;
            trav1 = trav1.next;
        }
        while (trav2 != null) {
            trav.next = new ListNode(trav2.val);
             trav =  trav.next;
            trav2 = trav2.next;
        }
        return head.next;

    }
}