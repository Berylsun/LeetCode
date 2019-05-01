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
        int num = 0;
        int val=0;
        if(l1==null || l2==null){
            return null;
        }
        while(l1.next == null&&l2.next!=null){
            l1.next =new ListNode(val);
        }
        while(l2.next == null&&l1.next!=null){
            l2.next =new ListNode(val);
        }
        
        if(l1.val+l2.val >= 10){
            if(l1.next == null && l2.next==null){
                l1.next =new ListNode(val);
                l2.next =new ListNode(val);
            }
            num = l1.val+l2.val-10;
            l1.next.val = l1.next.val+1;
        }else{
            num = l1.val+l2.val;
        }
        l1.val = num;
        l1.next = addTwoNumbers(l1.next,l2.next);
        return l1;
    }
}


public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;
            
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }
}
