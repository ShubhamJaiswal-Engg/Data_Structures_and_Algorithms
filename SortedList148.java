
// 148. Sort List

class SortedList148 {
    
    private ListNode midNode(ListNode head) {
        ListNode prevMid = null;
        while(head != null && head.next != null) {
            prevMid = (prevMid == null) ? head : prevMid.next;
            head = head.next.next;
        }
        ListNode mid = prevMid.next; 
        prevMid.next = null;

        return mid;        
    }

    private ListNode mergeSort(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode dummy = head;

        while(list1 != null && list2 != null) {
        if(list1.val < list2.val) {
            dummy.next = list1;
            list1 = list1.next; 
        } else {
            dummy.next = list2;
            list2 = list2.next;
        }
        dummy = dummy.next;                                                            
      }
        dummy.next = (list1 != null) ? list1 : list2;
        return head.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid = midNode(head);

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeSort(left, right);

    }
}