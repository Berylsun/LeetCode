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
     * O(nlogk)  n = total element   k = number of lists
     * O(logk)  recursion space
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return helper(lists, 0, lists.length - 1);
    }
    public ListNode helper(ListNode[] lists, int l, int r) {
        if (l < r) {
            int mid = (r - l) / 2 + l;
            ListNode ln = helper(lists, l, mid);
            ListNode rn = helper(lists, mid + 1, r);
            return merge(ln, rn);
        } else {
            return lists[l];
        }
    }
    public ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l != null || r != null) {
            if (l == null) {
                cur.next = r;
                break;
            }
            if (r == null) {
                cur.next = l;
                break;
            }

            if (l.val < r.val) {
                cur.next = new ListNode(l.val);
                l = l.next;
            } else {
                cur.next = new ListNode(r.val);
                r = r.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}