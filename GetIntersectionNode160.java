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

// Optimum Solution
// Complexity = O(n + m);

public class GetIntersectionNode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;

        // Two Pointing Approach
        //Total cover time (n + m)
        while( p1 != p2) {
            p1 = p1 == null ? headB : p1.next; //Reversing approach to get that same intersection point
            p2 = p2 == null ? headA : p2.next; // p1 interchage with p2 when p1 gets null vice-versa
        }
        return p1;
    }
}
