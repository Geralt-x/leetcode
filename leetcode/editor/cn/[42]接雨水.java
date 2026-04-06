
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 想象你在数组的任意一个位置 i，这个位置上方能积多少水？
     * 首先找到他左边最高的柱子leftmax，然后找到右边最高的柱子rightmax，
     * 则位置 i 的积水量为min(leftmax, rightmax) - height[i]。
     * 在双指针法中为什么leftmax<rightmax时就可以确定left处的积水量呢？
     * 这是因为此时left的左右屏障都以确定，且左边更短，储水量取决于leftmax，
     * 我们不需要知道left右边最高的高度是多少，只知道右边已经有一个比leftmax更高的屏障，
     * 确保水不会从右边流走，所以该位置的储水量就是leftmax-height[left]。
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
