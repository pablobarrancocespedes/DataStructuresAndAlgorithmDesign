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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        if(head == null){
            return null;
        }

        if (head.next == null || k <= 1){
            return head;
        } else {
            dummy.next = head;

            ListNode prevGroup = dummy;

            while(true){
                ListNode kth = prevGroup;

                for (int i = 0; i < k && kth != null; i++) {
                    kth = kth.next;
                }

                if(kth == null) break;

                ListNode groupStart = prevGroup.next;
                ListNode nextGroup = kth.next;

                ListNode prev = nextGroup;
                ListNode curr = groupStart;

                while (curr != nextGroup) {
                    ListNode nxt = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = nxt;
                }

                prevGroup.next = kth;     // kth ahora es la "cabeza" del bloque invertido
                prevGroup = groupStart;

            }
        }

        return dummy.next;

    }
} 