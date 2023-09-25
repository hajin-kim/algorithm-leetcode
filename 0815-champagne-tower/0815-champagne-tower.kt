class Solution {
    fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
        var dp = DoubleArray(query_row + 1)
        dp[0] = poured.toDouble()

        repeat(query_row) { row ->
            val newDp = DoubleArray(query_row + 1)

            repeat(row + 1) { column ->
                val overflowAmount = (dp[column] - 1.0).coerceAtLeast(0.0)
                newDp[column] += overflowAmount / 2
                newDp[column + 1] += overflowAmount / 2
            }

            dp = newDp
        }

        val result = dp[query_glass].coerceAtMost(1.0)
        return result
    }
}