class Solution {
    fun isMonotonic(nums: IntArray): Boolean {
        var i = 1
        var isIncreasing = false

        while (i < nums.size) {
            if (nums[i] > nums[i - 1]) {
                isIncreasing = true
                break
            } else if (nums[i] < nums[i - 1]) {
                break
            }
            ++i
        }

        while (i < nums.size) {
            if (nums[i] > nums[i - 1] && !isIncreasing || nums[i] < nums[i - 1] && isIncreasing) {
                return false
            }
            ++i
        }

        return true
    }
}