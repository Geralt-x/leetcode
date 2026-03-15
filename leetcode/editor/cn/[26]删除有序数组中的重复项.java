
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        // 慢指针
        int slow = 0;
        // 快指针，从index = 1开始
        for(int fast = 1; fast < nums.length; fast++){
            if(nums[fast] != nums[slow]){
                // 题目要求每个元素只出现一次，如果出现重复那么当前位置的元素需要保留
                // slow指针需要往后移动一位，将fast位置的元素赋给slow位置
                slow++;
                nums[slow] = nums[fast];
            }
        }
        // 返回不重复数组的长度
        return slow + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
