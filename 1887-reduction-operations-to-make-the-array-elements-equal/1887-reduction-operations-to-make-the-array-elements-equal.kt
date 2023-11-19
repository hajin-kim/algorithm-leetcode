class Solution {
    fun reductionOperations(nums: IntArray): Int {
        nums.sort()

        var result = 0
        var count = 0
        for (i in 1 until nums.size) {
            if (nums[i] != nums[i - 1])
                ++count
            result += count
        }

        return result
    }
}