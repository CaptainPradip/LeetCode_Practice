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
    public ListNode getIntersectionNode(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode trav = l1;
        while (trav != null) {
            set.add(trav);
            trav = trav.next;
        }
        trav = l2;
        while (trav != null) {
            if (set.contains(trav)) {
                return trav;
            }
            trav = trav.next;
        }

        return null;
    }
}