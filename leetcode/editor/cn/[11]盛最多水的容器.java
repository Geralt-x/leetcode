
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            // 计算当前面积,面积取决于最矮的那条柱子
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            // 哪个柱子较矮,就移动哪边
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
