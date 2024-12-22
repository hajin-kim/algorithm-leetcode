class Solution {
    private fun backtrack(
        nums: IntArray,
        result: MutableList<List<Int>>,
        used: BooleanArray,
        current: MutableList<Int>,
    ) {
        if (current.size == nums.size) {
            result += current.toMutableList()
            return
        }
        for (i in nums.indices) {
            if (used[i]) {
                continue
            }

            used[i] = true
            current += nums[i]
            backtrack(nums, result, used, current)
            current.removeLast()
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
