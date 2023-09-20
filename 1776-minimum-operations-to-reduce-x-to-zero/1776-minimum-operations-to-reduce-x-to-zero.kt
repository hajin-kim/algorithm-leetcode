class Solution {
    fun minOperations(nums: IntArray, x: Int): Int {
        val sum = nums.sum()

        if (sum < x) {
            return -1
        }

        var result = -1
        var left = 0
        var accumulated = 0
        nums.forEachIndexed { right, num ->
            if (accumulated <= sum - x) {
                accumulated += num
            }
            while (accumulated > sum - x) {
                accumulated -= nums[left++]
            }
            if (accumulated == sum - x) {
                result = maxOf(result, right - left + 1)
            }
        }

        if (result == -1) {
            return -1
        }
        
        return nums.size - result
    }
}