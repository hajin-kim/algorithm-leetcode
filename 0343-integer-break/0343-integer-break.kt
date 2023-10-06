class Solution {
    fun integerBreak(n: Int): Int {
        if (n == 2)
            return 1
        if (n == 3)
            return 2

        val dp = mutableMapOf<Pair<Int, Int>, Int>()

        fun solve(remaining: Int, current: Int): Int {
            if (remaining == 1)
                return current + 1

            val key = remaining to current
            if (dp[key] != null)
                return dp[key]!!

            val result = maxOf(
                solve(remaining - 1, current + 1),
                solve(remaining - 1, 1) * current,
            )
            dp[key] = result
            
            return result
        }

        return solve(n - 1, 1)
    }
}