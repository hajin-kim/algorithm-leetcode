class Solution {
    private val MAX = 1000000000

    fun paintWalls(cost: IntArray, time: IntArray): Int {
        val n = cost.size

        val cache = Array(n) { mutableMapOf<Int, Int>() }
        fun dp(index: Int, freePainters: Int): Int {
            if (index + freePainters >= n)
                return 0
            if (index >= n)
                return MAX

            if (freePainters in cache[index])
                return cache[index][freePainters]!!

            val chooseNow = dp(index + 1, freePainters + time[index]) + cost[index]
            val freePaintNow = dp(index + 1, freePainters - 1)

            val result = minOf(chooseNow, freePaintNow)
            cache[index][freePainters] = result

            return result
        }

        return dp(0, 0)
    }
}