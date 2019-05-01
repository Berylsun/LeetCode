/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {        
        while(head != null && head.val==val){ // head!=null must be the first one!!!
            head=head.next;
        }        
        ListNode current=head;
        while(current!=null){
            if(current.next!=null&&current.next.val==val){
                current.next=current.next.next;
            }else{
                current=current.next;
            }            
        }
        return head;
    }
}
