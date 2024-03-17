class Solution {
    fun findMaxLength(nums: IntArray): Int {
        val n = nums.size
        var count = 0
        val maxIndexByCount = hashMapOf(0 to -1)
        var result = 0
        for (i in nums.indices) {
            count += if (nums[i] == 1) 1 else -1

            if (count in maxIndexByCount)
                result = maxOf(result, i - maxIndexByCount[count]!!)
            else
                maxIndexByCount[count] = i
        }

        return result
    }
}
