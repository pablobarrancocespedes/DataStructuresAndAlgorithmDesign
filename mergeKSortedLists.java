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
       if (lists == null || lists.length == 0) return null;
        return mergeRange(lists, 0, lists.length - 1);
    }

    private ListNode mergeRange(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        int m = l + (r-l)/2;
        ListNode left = mergeRange(lists,l,m);
        ListNode right = mergeRange(lists,m+1,r);
        return mergeTwoLists(left,right);
    }

    private ListNode mergeTwoLists(ListNode listA, ListNode listB){
        if(listA == null){
            return listB;
        } else if (listB == null){
            return listA;
        }

        ListNode res = new ListNode();

        if(listA.val <= listB.val){
            res.val = listA.val;
            res.next = mergeTwoLists(listA.next,listB);
        } else {
            res.val = listB.val;
            res.next = mergeTwoLists(listA, listB.next);
        }

        return res;
    }
}
