public class removeNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode quick = head;
        ListNode dummy = new ListNode(0,head);
        ListNode slow = dummy;
        int idx = 1;
        while (quick.next != null) {
            if (idx >= n) {
                slow = slow.next;
            }
            quick = quick.next;
            idx++;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
