
// 23. Merge k Sorted Lists

class MergKSortList23 {
    // O(K. N)
    private ListNode mergeLL(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = (l1 == null) ? l2 : l1;

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) {
            return null;
        }
        if (lists == null || lists.length == 0) return null;

        for(int i = 1; i < lists.length; i++) {
            lists[0] = mergeLL(lists[0], lists[i]);
        }
        return lists[0];
    }
}