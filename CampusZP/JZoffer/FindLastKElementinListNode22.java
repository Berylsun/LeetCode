/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * O()
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node = head;
        ListNode s = head;
        for (int i = 0; i < k; i++) {
            node = node.next;
        }
        while (node != null) {
            s = s.next;
            node = node.next;
        }
        return s;
    }
}