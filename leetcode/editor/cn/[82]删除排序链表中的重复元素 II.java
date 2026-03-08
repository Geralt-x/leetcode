
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

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
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode p = head;
        while (p != null) {
            map.put(p.val, map.getOrDefault(p.val, 0) + 1);
            p = p.next;
        }
        ListNode dummy = new ListNode(101);
        ListNode res = dummy;
        p = head;
        while (p != null) {
            if (map.get(p.val) == 1) {
                res.next = p;
                res = res.next;
            }
            p = p.next;
        }
        res.next = null;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
