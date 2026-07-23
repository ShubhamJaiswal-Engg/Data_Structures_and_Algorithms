// 160. Intersection of Two Linked Lists

public class GetIntersectionNode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        while (headB != null) {
            ListNode temp = headA;
            while (temp != null) {
                if (temp == headB) {
                    return headB;
                    };
                    temp = temp.next;
                };
                headB = headB.next;
                    };
                return null;
    }
}