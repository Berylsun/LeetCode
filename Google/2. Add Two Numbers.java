//max(m, n)

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
        if (l1 == null || l2 == null) return null;
        
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int num = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }
            
            cur.next = new ListNode(num % 10);
            num = num / 10;
            
            cur = cur.next;
        }
        
        //DON'T FORGET PLUS 1
        if (num != 0) {
            cur.next = new ListNode(1);
        }
        
        return res.next;
        
    }
}
