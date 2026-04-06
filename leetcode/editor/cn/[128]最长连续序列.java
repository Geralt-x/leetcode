import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        // 应该遍历 set 而不是 nums 数组，这样可以避免处理重复元素
        for (int num : set) {
            // 判断一次这个数是不是连续序列的开头那个数。
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLen = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    curLen++;
                }
                res = Math.max(res, curLen);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
