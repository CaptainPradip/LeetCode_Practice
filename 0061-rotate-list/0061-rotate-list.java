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
    public ListNode rotateRight(ListNode head, int k) {
        // First Find the length of the linkList
        // update the k as K more than the length then k= k%length
        // then use slow and Fast pointer to get the right kth Node
        // split the LinkList with the kth node the join it next to fast pointer

        ListNode fast = head;
        ListNode prev = head;
        int length = 1;
        if (head == null || head.next == null) {
            return head;
        }
        while (fast.next != null) {
            fast = fast.next;
            length++;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        fast = head;
        while (fast.next != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            prev = prev.next;
            fast = fast.next;
        }
        ListNode nextList = prev.next;
        fast.next = head;
        prev.next = null;
        head = nextList;
        return head;
    }
}