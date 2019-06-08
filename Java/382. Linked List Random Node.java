/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode head;
    private Random rdm;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        rdm = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode temp = head;
        int i = 0;
        int res = 0;
        while (temp != null) {
            if (rdm.nextInt(++i) == 0) {
                res = temp.val;
            }
            temp = temp.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
