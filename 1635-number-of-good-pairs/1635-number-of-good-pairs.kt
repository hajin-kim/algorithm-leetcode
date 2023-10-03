class Solution {
    fun numIdenticalPairs(nums: IntArray): Int {
        val MAX = 100

        val count = IntArray(MAX + 1)
        nums.forEach { ++count[it] }

        return count.sumOf { if (it > 1) it * (it - 1) / 2 else 0 }
    }
}