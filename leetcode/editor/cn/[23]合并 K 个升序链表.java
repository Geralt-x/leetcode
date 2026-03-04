
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 创建最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b)-> (a.val - b.val));
        // 头节点加入优先级队列
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        // 不断从最小堆弹出根节点（最小）
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            p.next = minNode;
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
            // 链表不断前移
            p = p.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
