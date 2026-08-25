// 86. Partition List

class partitionList86 {
    public ListNode partition(ListNode head, int x) {
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;

        while(head != null) {
            if(head.val >= x) {
                after.next = head;
                after = after.next;
            } else {
                before.next = head;
                before = before.next;
            }
            head = head.next;
        };
        after.next = null;
        before.next = after_head.next;

    return before_head.next;      
    
    }
}