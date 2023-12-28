internal class Solution {
    private val MAX = 1000000000

    private fun Int.lengthOfLength(): Int {
        return if (this <= 1) return 0 else this.toString().length
    }

    private fun Int.encodeLength(): Int {
        return 1 + this.lengthOfLength()
    }

    fun getLengthOfOptimalCompression(s: String, k: Int): Int {
        val n = s.length
        val dp = Array(n + 1) { IntArray(k + 1) { MAX } }
        dp[0][0] = 0

        for (i in 1..n) {
            for (remainingK in 0..k) {
                var subLength = 0
                var toDelete = 0
                for (l in i downTo 1) {
                    if (s[l - 1] == s[i - 1])
                        subLength++
                    else
                        toDelete++

                    if (remainingK - toDelete >= 0) {
                        dp[i][remainingK] = minOf(
                            dp[i][remainingK],
                            dp[l - 1][remainingK - toDelete] + subLength.encodeLength(),
                        )
                    }
                }

                if (remainingK > 0)
                    dp[i][remainingK] = minOf(dp[i][remainingK], dp[i - 1][remainingK - 1])
            }
        }

        return dp[n][k]
    }
}