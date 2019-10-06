/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        if (l1 == null && l2 == null) return null;
        ListNode cur = dummy;
        int sum = 0;
        while (l1 != null || l2 != null) {
            //can be optimized
            if (l1 != null && l2 != null) {
                sum += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }else if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }else {
                sum += l2.val;
                l2 = l2.next;
            }
            
            if (sum > 9) {
                cur.next = new ListNode(sum - 10);
                sum = 1;
            }else {
                cur.next = new ListNode(sum);
                sum = 0;
            }
            cur = cur.next;
        }
        //don't forget!!!
        if (sum == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}



public class _2_AddTwoNumbers {
    /**

     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8

     time : O(n)
     space : O(n)

     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int sum = 0;
        ListNode cur = dummy;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;
        }
        if (sum == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}
