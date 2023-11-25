class Solution {
    fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
        val n = nums.size
        val result = IntArray(n)

        var sumByCurrent = nums.sum()

        for (i in nums.indices) {
            result[i] = sumByCurrent + nums[i] * (i * 2 - n)
            sumByCurrent -= nums[i] * 2
        }

        return result
    }
}