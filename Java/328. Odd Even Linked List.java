/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null){return head;}
        int a = 1;
        ListNode current1 = head;
        ListNode current2 = head.next;
        ListNode headeven = head.next;
        while(current2!=null&&current2.next!=null){
            ListNode odd = current1.next.next;
            current1.next = current1.next.next;
            current1 = odd;
            ListNode even = current2.next.next;
            current2.next = current2.next.next;
            current2 = even;
        }
        current1.next=headeven;
        return head;
    }
}
