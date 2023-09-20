class Solution {
    fun minOperations(nums: IntArray, x: Int): Int {
        val sum = nums.sum()

        if (sum < x) {
            return -1
        }

        val target = sum - x

        var result = -1
        var left = 0
        var accumulatedNegative = 0
        nums.forEachIndexed { right, num ->
            accumulatedNegative += num

            while (accumulatedNegative > target) {
                accumulatedNegative -= nums[left++]
            }
            if (accumulatedNegative == target) {
                result = maxOf(result, right - left + 1)
            }
        }

        if (result == -1) {
            return -1
        }

        return nums.size - result
    }
}