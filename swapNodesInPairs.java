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
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        } else {
            ListNode aux = new ListNode();
            aux.val = head.val;
            aux.next = head.next.next;
            head.val = head.next.val;
            head.next = aux;
            swapPairs(head.next.next);
        }

        return head;


    }
}
