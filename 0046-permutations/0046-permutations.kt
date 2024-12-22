class Solution {
    private fun backtrack(
        nums: IntArray,
        result: MutableList<List<Int>>,
        used: BooleanArray,
        current: MutableList<Int>,
    ) {
        if (current.size == nums.size) {
            result += current
            return
        }
        for (i in nums.indices) {
            if (used[i]) {
                continue
            }

            used[i] = true
            val next = current.toMutableList()
            next += nums[i]
            backtrack(nums, result, used, next)
            used[i] = false
        }
    }

    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val used = BooleanArray(nums.size)

        backtrack(nums, result, used, mutableListOf())
        return result
    }
}
