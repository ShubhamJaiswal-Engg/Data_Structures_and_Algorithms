
// 19. Remove Nth Node From End of List

class RemoveNodeFromEnd19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // count size using a separate pointer, keep 'head' intact
        int sz = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            sz++;
        }

        // removing the head itself (first node from the front)
        if (n == sz) {
            return head.next;
        }

        // walk to the node just before the one we want to remove
        ListNode prev = head;
        int toEnd = sz - n;       // number of steps to take
        int i = 1;
        while (i < toEnd) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return head;
    }
}