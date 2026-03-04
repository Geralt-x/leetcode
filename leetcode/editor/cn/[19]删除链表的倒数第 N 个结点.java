
//leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(-1);
        res.next = head;
        // 删除倒数n个节点，就要找到待删除的前一个节点
        ListNode x = findFromEnd(res, n+1);
        x.next = x.next.next;
        return res.next;
    }

    /**
     * 这个算法利用了两个指针（快慢指针）的固定距离差来定位倒数第 k 个节点。具体原理如下：
     *
     * 初始化：两个指针 p1 和 p2 都指向链表头节点 head。
     *
     * 快指针先走 k 步：让 p1 先向前移动 k 步，此时 p1 领先 p2 正好 k 个节点。
     *
     * 同步移动：然后同时移动 p1 和 p2，每次各走一步。
     * 当 p1 走到链表末尾（即 p1 == null）时，它一共走了 n 步（n 为链表总长度）。
     * 由于 p2 比 p1 少走 k 步，所以 p2 走了 n - k 步，
     * 此时 p2 指向的节点就是从开头数第 n - k + 1 个节点，也就是倒数第 k 个节点。
     *
     * 对于倒数第二个节点（k=2），过程同理：p1 先走 2 步，然后两个指针同步移动，
     * 当 p1 到达末尾时，p2 恰好指向倒数第二个节点。
     * 这是因为 p1 和 p2 始终相距 2 个节点，p1 到末尾时，p2 自然距离末尾也是 2 步。
     * @param head
     * @param n
     * @return
     */
    private ListNode findFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1=p1.next;
        }
        ListNode p2=head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
