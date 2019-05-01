/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast!=null){
            slow = slow.next;
        }
        fast = head;
        slow = reverse(slow);
        while (slow != null){
            if(slow.val != fast.val){return false;} //must be .val!!!
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode newhead=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=newhead;
            newhead=head;
            head=next;
        }
        return newhead;
        
    }
}
