import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 跳过重复的数字
                continue;
            }
            // 双指针,目标是找到nums[left] + nums[right] = -nums[i]
            int left = i + 1, right = nums.length - 1;
            int target = -nums[i];
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 继续查找下一组
                    left++;
                    right--;
                    // 跳过重复的数字
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < target) {
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
