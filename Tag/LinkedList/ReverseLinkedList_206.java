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
class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode prenode = null;
        ListNode node = head;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = prenode;
            prenode = node;
            node = tmp;
        }
        return prenode;
    }
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}