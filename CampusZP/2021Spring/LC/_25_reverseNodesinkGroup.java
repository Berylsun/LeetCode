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
    /**
     * O(n)
     * O(n)
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int count = 0;
        ListNode cur = head;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count != k) {
            return head;
        }
        cur = reverseKGroup(cur, k);
        ListNode pre = cur;
        ListNode now = head;
        while (count > 0) {
            ListNode tmp = now.next;
            now.next = pre;
            pre = now;
            now = tmp;
            count--;
        }
        return pre;
    }

    /**
     * O(n)
     * O(1)
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null) {
            ListNode cur = pre;
            for (int i = 0; i < k; i++) {
                cur = cur.next;
                if (cur == null) {
                    return dummy.next;
                }
            }

            ListNode nex = cur.next;
            ListNode[] ls = reverse(pre.next, cur);
            pre.next = ls[0];
            cur = ls[1];
            cur.next = nex;
            pre = cur;
        }
        return dummy.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode cur = head;
        while (prev != tail) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return new ListNode[]{tail, head};
    }
}