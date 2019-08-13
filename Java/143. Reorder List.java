/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode cur = head;
        ListNode mid = findMid(head);
        ListNode head2 = reverse(mid.next);
        mid.next = null;
        while (head2 != null) {
            ListNode temp = cur.next;
            cur.next = head2;
            head2 = head2.next;
            cur = cur.next;
            cur.next = temp;
            cur = temp;
        }
    }
    
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
