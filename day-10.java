class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ptr = head;
        ListNode last = new ListNode(0);
        ListNode start = last;
        int temp = -999;
        while(ptr!=null && ptr.next!=null){
            if(ptr.val!=ptr.next.val  && temp!=ptr.val){
                last.next = ptr;
                last = ptr;
            }
            else{
                temp = ptr.val;
            }
            ptr=ptr.next;
        }
        if(ptr!=null && ptr.val!=temp)
            last.next = ptr;
        else
            last.next = null;
        return start.next;
    }
}
