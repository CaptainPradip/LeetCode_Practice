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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((a,b)-> a.val-b.val);

        for(ListNode list : lists){
            if(list!=null)
                heap.add(list);
        }
        ListNode dummy = new ListNode(0);
        ListNode trav  = dummy;
        while(!heap.isEmpty()){
            ListNode minNode = heap.poll();
            trav.next = new ListNode(minNode.val);
            if(minNode.next!=null){
                heap.add(minNode.next);
            }
            trav = trav.next;
        }
        return dummy.next;

        
    }
}