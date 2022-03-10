class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1;
        ListNode h2 = l2;
        int sum = 0;
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode ptr = res;
        while(h1!=null && h2!=null){
            int cur = h1.val+h2.val+carry;
            res.next = new ListNode(cur%10);
            carry = cur/10;
            h1 = h1.next;
            h2 = h2.next;
            res = res.next;
        }
        while(h1!=null){
            int cur = h1.val+carry;
            res.next = new ListNode(cur%10);
            carry = cur/10;
            h1 = h1.next;
            res = res.next;
        }
        while(h2!=null){
            int cur = h2.val+carry;
            res.next = new ListNode(cur%10);
            carry = cur/10;
            h2 = h2.next;
            res = res.next;
        }
        if(carry>0)
            res.next = new ListNode(carry);
        return ptr.next;
    }
}
