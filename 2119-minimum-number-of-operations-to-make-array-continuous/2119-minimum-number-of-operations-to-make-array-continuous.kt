class Solution {
    fun minOperations(nums: IntArray): Int {
        if (nums.size == 1)
            return 0

        val sortedDistinct = nums.sorted().distinct().toIntArray()

        var result = Int.MAX_VALUE

        sortedDistinct.forEachIndexed { index, num ->
            val end = num + nums.size - 1

            val endIndex = sortedDistinct
                .binarySearch(end)
                .let {
                    if (it < 0) -it - 2 // exclusive
                    else it
                }

            result = minOf(result, nums.size - endIndex + index - 1)
        }

        return result
    }
}