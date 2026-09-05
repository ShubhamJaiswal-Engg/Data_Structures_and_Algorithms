// 2. Add Two Numbers

class AddTwoNumber2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) { sum += l1.val; l1 = l1.next; }
            if (l2 != null) { sum += l2.val; l2 = l2.next; }

            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        return result.next;
    }
}

// Optimising Space
class AddTwoNumber2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = l1;
        ListNode curr = result;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        return result.next;
    }
}

// More Optimised

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        dummy.next = l1;  // reuse l1 as the result list
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            if (l1 == null) {
                l1 = new ListNode(0);
                curr.next = l1;
            }

            int sum = carry + l1.val + (l2 != null ? l2.val : 0);
            l1.val = sum % 10;       // ✅ mutation used consistently
            carry = sum / 10;

            curr = l1;
            l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}