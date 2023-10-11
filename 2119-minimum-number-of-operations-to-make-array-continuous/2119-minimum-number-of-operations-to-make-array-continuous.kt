class Solution {
    fun minOperations(nums: IntArray): Int {
        val n = nums.size
        if (n == 1)
            return 0

        val sortedDistinct = nums.distinct().sorted().toIntArray()

        var result = Int.MAX_VALUE

        sortedDistinct.forEachIndexed { index, num ->
            val end = num + n - 1

            val endIndex = sortedDistinct
                .binarySearch(end)
                .let {
                    if (it < 0) -it - 2 // exclusive
                    else it
                }

            result = minOf(result, n - endIndex + index - 1)
        }

        return result
    }
}