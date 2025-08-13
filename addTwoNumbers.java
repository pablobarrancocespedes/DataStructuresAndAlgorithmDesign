class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1,l2,0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int acarreo) {
        if(l1 == null && l2== null && acarreo == 0){
            return null;
        }
        //Suma de valores
        int v1 = (l1 != null) ? l1.val : 0;
        int v2 = (l2 != null) ? l2.val : 0;
        //Calcular acarreo y modulo 10
        int sum = v1+v2+acarreo;
        //ListNode
        ListNode ln = new ListNode(sum%10);

        ListNode next1 = (l1 != null) ? l1.next : null;
        ListNode next2 = (l2 != null) ? l2.next : null;

        ln.next = addTwoNumbers(next1,next2, sum/10);

        return ln;
    }
}
