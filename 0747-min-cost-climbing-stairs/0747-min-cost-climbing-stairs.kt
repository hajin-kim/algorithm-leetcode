class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        var now = 0
        var next = 0
        for (i in 1 until cost.size) {
            val newNext = minOf(now + cost[i - 1], next + cost[i])
            now = next
            next = newNext
        }
        return next
    }
}