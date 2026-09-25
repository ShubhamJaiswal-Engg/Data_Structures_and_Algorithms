
// 237. Delete Node in a Linked List

class LinkedDelNode237 {
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while(node.next != null) {
            int temp = node.val;
            node.val = node.next.val;
            node.next.val = temp;

            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
}