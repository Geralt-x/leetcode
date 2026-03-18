
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 0){
                swap(nums, ptr, i);
                ptr++;
            }
        }
        for (int i = ptr; i < n; i++) {
            if(nums[i] == 1){
                swap(nums, ptr, i);
                ptr++;
            }
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
