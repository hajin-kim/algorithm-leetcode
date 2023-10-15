class Solution {
    private val MODULO = (1e9 + 7).toInt()
    fun numWays(steps: Int, arrLen: Int): Int {
        if (arrLen == 1)
            return 1

        val cacheSize = (steps + 2).coerceAtMost(arrLen)

        var prev = IntArray(cacheSize) { 0 }
            .apply {
                this[0] = 1
                this[1] = 1
            }
        var new = IntArray(cacheSize)

        for (step in 1 until steps) {
            for (i in 0 until (step + 2).coerceAtMost(arrLen)) {
                // Stay
                var result = prev[i]
                // Right
                if (i + 1 < arrLen) {
                    result += prev[i + 1]
                    result %= MODULO
                }
                // Left
                if (i - 1 >= 0) {
                    result += prev[i - 1]
                    result %= MODULO
                }
                new[i] = result
            }

            val temp = new
            new = prev
            prev = temp
        }

        return prev[0]
    }
}