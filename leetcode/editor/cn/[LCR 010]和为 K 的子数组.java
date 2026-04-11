import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        // key: 前缀和, value: 前缀和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 默认前缀和为 0 的次数为 1
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            // 前缀和为 sum - k 的次数,就说明有几个子数组的和为 k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            // 添加当前前缀和出现的次数
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
