import java.util.LinkedList

class Solution {
    private fun subsetsMutable(
        nums: IntArray,
        i: Int,
        now: LinkedList<Int>,
        result: MutableList<List<Int>>,
    ) {
        if (i == nums.size) {
            @Suppress("UNCHECKED_CAST")
            result += now.clone() as List<Int>
            return
        }

        subsetsMutable(nums, i + 1, now, result)
        now += nums[i]
        subsetsMutable(nums, i + 1, now, result)
        now.removeLast()
    }

    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        subsetsMutable(nums, 0, LinkedList(), result)

        return result
    }
}
