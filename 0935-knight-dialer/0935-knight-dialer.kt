class Solution {
    private val MODULO = 1000000007

    fun knightDialer(n: Int): Int {
        var dp = IntArray(10) { 1 }
        repeat(n - 1) {
            val new = IntArray(10)
            new[0] = (dp[4] + dp[6]) % MODULO
            new[1] = (dp[6] + dp[8]) % MODULO
            new[2] = (dp[7] + dp[9]) % MODULO
            new[3] = (dp[4] + dp[8]) % MODULO
            new[4] = ((dp[3] + dp[9]) % MODULO + dp[0]) % MODULO
            new[5] = 0
            new[6] = ((dp[1] + dp[7]) % MODULO + dp[0]) % MODULO
            new[7] = (dp[2] + dp[6]) % MODULO
            new[8] = (dp[1] + dp[3]) % MODULO
            new[9] = (dp[2] + dp[4]) % MODULO
            dp = new
        }

        return dp.fold(0) { acc, i -> (acc + i) % MODULO }
    }
}