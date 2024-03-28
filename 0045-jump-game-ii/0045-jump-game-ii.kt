class Solution {
    fun jump(nums: IntArray): Int {
        val n = nums.size
        val distances = IntArray(n) { Int.MAX_VALUE }
        distances[0] = 0

        for (i in nums.indices) {
            val num = nums[i]
            val distance = distances[i]

            val jump = distance + 1
            for (j in (i + 1)..(i + num).coerceAtMost(n - 1)) {
                distances[j] = minOf(distances[j], jump)
            }
        }
        
        return distances.last()
    }
}
