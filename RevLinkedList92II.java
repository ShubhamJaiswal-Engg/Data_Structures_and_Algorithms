
// 92. Reverse Linked List II

class RevLinkedList92II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;

        ListNode answer = new ListNode(0);
        answer.next = head;

        ListNode leftNode = answer;
        for (int i = 1; i < left; i++) {
            leftNode = leftNode.next;
        }

        ListNode prev = null;
        ListNode curr = leftNode.next;
        ListNode next = null;

        for (int j = left; j <= right; j++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        leftNode.next.next = next;
        leftNode.next = prev;

        return answer.next;
    }
}