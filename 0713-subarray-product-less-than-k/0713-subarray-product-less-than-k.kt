class Solution {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        if (k == 0)
            return 0

        var left = 0
        var product = 1
        var result = 0

        repeat(nums.size) { right->
            product *= nums[right]

            while (left <= right && product >= k) {
                product /= nums[left]
                ++left
            }

            result += (right + 1 - left)
        }

        return result
    }
}
