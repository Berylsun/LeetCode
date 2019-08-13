/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=len(headA);
        int lenB=len(headB);
        while(lenA!=lenB){
            if(lenA>lenB){
                headA=headA.next;
                lenA--;
            }else{
                headB=headB.next;
                lenB--;
            }
        }
        while(lenA>0){
            if(headA==headB){
                return headA;
            }else{
                headA=headA.next;
                headB=headB.next;
            }
            lenA--;
        }
        return null;
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
