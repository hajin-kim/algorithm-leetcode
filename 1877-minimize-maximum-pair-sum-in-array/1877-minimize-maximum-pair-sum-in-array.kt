class Solution {
    fun minPairSum(nums: IntArray): Int {
        nums.sort()

        val last = nums.size - 1
        var max = 0
        for (i in 0 until nums.size / 2) {
            max = maxOf(max, nums[i] + nums[last - i])
        }

        return max
    }
}