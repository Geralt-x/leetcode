
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
    public ListNode partition(ListNode head, int x) {
        ListNode t1 = new ListNode(-1);
        ListNode t2 = new ListNode(-1);
        ListNode p = head, p1 = t1, p2 = t2;
        while(p != null){
            if(p.val < x){
                p1.next = p;
                p1 = p1.next;
            }else{
                p2.next = p;
                p2 = p2.next;
            }
            // 断开原链表每个节点的next指针，否则最后会形成环
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        // 第一个链表的尾巴拼接第二个链表的开头
        p1.next = t2.next;
        return t1.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
