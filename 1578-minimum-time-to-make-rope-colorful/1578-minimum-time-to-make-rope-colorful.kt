class Solution {
    fun minCost(colors: String, neededTime: IntArray): Int {
        var localMax = 0
        var result = neededTime.sum()

        var prev = '-'

        for (i in colors.indices) {
            val now = colors[i]

            if (prev == now) {
                localMax = maxOf(localMax, neededTime[i])
            } else {
                result -= localMax
                localMax = neededTime[i]
            }

            prev = now
        }

        result -= localMax
        return result
    }
}