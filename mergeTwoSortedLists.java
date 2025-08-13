class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode result = new ListNode();
        if (list1.val <= list2.val) {                 // consume solo list1
            result.val = list1.val;
            result.next = mergeTwoLists(list1.next, list2);
        } else {                                      // consume solo list2
            result.val = list2.val;
            result.next = mergeTwoLists(list1, list2.next);
        }
        return result;
    }
}
