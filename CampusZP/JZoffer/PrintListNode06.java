/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * O(n)
     * O(n)
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        int j = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            res[j++] = list.get(i);
        }
        return res;
    }
}