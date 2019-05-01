/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length=len(head);
        ListNode current=head;
        if(length-n-1>0){
            for(int i=0;i<length-n-1;i++){
                current=current.next;
            }
            current.next=current.next.next;
        }else if(length==n){
            head=head.next;
        }else{
            head.next=head.next.next;
        }
        
        return head;
        
    }
    public int len(ListNode head){
        int a=0;
        while(head!=null){
            head=head.next;
            a++;
        }
        return a;
    }
}




public ListNode removeNthFromEnd(ListNode head, int n) {
    
    ListNode start = new ListNode(0);
    ListNode slow = start, fast = start;
    slow.next = head;
    
    //Move fast in front so that the gap between slow and fast becomes n
    for(int i=1; i<=n+1; i++)   {
        fast = fast.next;
    }
    //Move fast to the end, maintaining the gap
    while(fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    //Skip the desired node
    slow.next = slow.next.next;
    return start.next;
}
