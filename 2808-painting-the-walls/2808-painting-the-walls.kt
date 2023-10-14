class Solution {
    private val MAX = 1000000000

    fun paintWalls(cost: IntArray, time: IntArray): Int {
        val n = cost.size

        val cache = Array(n) { IntArray(n + 1) { -1 } }
        fun dp(index: Int, shouldPaint: Int): Int {
            if (shouldPaint <= 0)
                return 0

            if (index == n)
                return MAX

            if (cache[index][shouldPaint] != -1)
                return cache[index][shouldPaint]

            val chooseNow = dp(index + 1, shouldPaint - 1 - time[index]) + cost[index]
            val freePaintNow = dp(index + 1, shouldPaint)

            val result = minOf(chooseNow, freePaintNow)
            cache[index][shouldPaint] = result

            return result
        }

        return dp(0, n)
    }
}