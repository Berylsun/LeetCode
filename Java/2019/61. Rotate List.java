/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {return head;}
        int i = 1;
        ListNode temp = head;
        //find the length of the LinkedList 
        while (temp.next != null) {
            i++;
            temp = temp.next;
        }
        if (i == 1) {return head;}
        k = k % i; // i is the length of the list
        if (k == 0) {
            return head;
        }
        
        // In each time, let tail be head 
        for (int j = 0; j < k; j++) {
            ListNode node = head;
            while (node.next.next != null) {
                node = node.next;
            }
            ListNode cur = node.next;
            node.next = null;
            cur.next = head;
            head = cur;            
        }
        return head;
    }
}



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            len++;
        }
        
        node.next = head; // connected the list as a circle
        for (int i = 0; i < len - k % len - 1; i++) {
            head = head.next;
        }
        ListNode res = head.next; // head.next is the head of the result!!!
        head.next = null; // disconnected the edge before the head of the result
        return res;
    }    
}
