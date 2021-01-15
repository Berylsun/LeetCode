/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode node = res;
        int count = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                count += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                count += l2.val;
                l2 = l2.next;
            }
            node.next = new ListNode(count % 10);
            count /= 10;
            node = node.next;
        }
        if (count != 0) {
            node.next = new ListNode(1);
        }
        return res.next;
    }
}