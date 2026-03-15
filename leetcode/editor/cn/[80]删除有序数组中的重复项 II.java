
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, count = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            count = nums[fast] == nums[slow] ? count + 1: 1;
            if (count <= 2) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
