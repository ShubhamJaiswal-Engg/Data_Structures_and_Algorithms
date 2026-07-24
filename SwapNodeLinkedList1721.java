class SwapNodeLinkedList1721 {
    public ListNode swapNodes(ListNode head, int k) {
        int sz = 0;
        ListNode temp = head;
        while (temp != null) {
            sz++;
            temp = temp.next;
        }

        ListNode node1 = head;
        for (int i = 1; i < k; i++) {
            node1 = node1.next;
        }

        ListNode node2 = head;
        for (int i = 1; i <= sz - k; i++) {
            node2 = node2.next;
        }

        int t = node1.val;
        node1.val = node2.val;
        node2.val = t;

        return head;
    }
}