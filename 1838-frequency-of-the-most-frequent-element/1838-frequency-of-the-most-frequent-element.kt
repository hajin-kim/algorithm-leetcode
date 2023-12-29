class Solution {
    fun maxFrequency(nums: IntArray, k: Int): Int {
        nums.sort()

        var result = 1
        var consumed = 0L
        var left = 0
        for (right in 1 until nums.size) {
            val area = let {
                val diff = nums[right] - nums[right - 1]
                val width = right - left
                diff.toLong() * width
            }

            consumed += area

            while (consumed > k) {
                consumed -= nums[right] - nums[left]
                ++left
            }

            result = maxOf(result, right - left + 1)
        }

        return result
    }
}