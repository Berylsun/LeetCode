//O(nlogk) where k is the number of linked lists, O(n)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.offer(lists[i]);
            }          
        }
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            cur.next = new ListNode(temp.val);
            cur = cur.next;
            if (temp.next == null) continue;
            queue.offer(temp.next);            
        }
        return dummy.next;
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }
    
    public ListNode sort(ListNode[] lists, int i, int j) {
        if (i >= j) return lists[i];
        int mid = (j - i) / 2 + i;
        ListNode l1 = sort(lists, i, mid);
        ListNode l2 = sort(lists, mid + 1, j);
        return merge(l1, l2);
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }else {
            l2.next = merge(l2.next, l1);
            return l2;
        }
    }
    
}
