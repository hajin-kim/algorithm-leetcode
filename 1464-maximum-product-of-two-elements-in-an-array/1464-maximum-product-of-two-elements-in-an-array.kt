class Solution {
    fun maxProduct(nums: IntArray): Int {
        var first = 0
        var second = 0
        for (i in nums.indices) {
            if (nums[i] >= first) {
                second = first
                first = nums[i]
            } else if (nums[i] > second) {
                second = nums[i]
            }
        }
        return (first - 1) * (second - 1)
    }
}