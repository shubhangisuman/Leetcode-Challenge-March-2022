//Question link - https://leetcode.com/problems/rotate-list/


class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0)
            return head;
        ListNode ptr = head;
        int len = 0;
        while(ptr.next!=null){
            len++;
            ptr = ptr.next;
        }
        len++;
        k = k%len; //KEY POINT
        if(k==0)
            return head;
        ListNode end = head;
        int c = len-k-1;
        while(end!=null && c-->0){
            end=end.next;
        }
        ListNode start = end.next;
        end.next = null;
        ptr.next = head;
        return start;
    }
}
