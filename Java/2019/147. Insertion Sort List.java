//n^2, 1
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head, pre = null, temp = null;
        while (cur != null && cur.next != null) {            
            if (cur.val <= cur.next.val){
                cur = cur.next;
            }else {
                temp = cur.next; 
                cur.next = temp.next;
                pre = dummy;
                while (pre.next.val <= temp.val) {
                    pre = pre.next;
                }
                temp.next = pre.next;
                pre.next = temp;
            }
        }
        return dummy.next;
    }
}
