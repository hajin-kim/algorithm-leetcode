class Solution {
    val MOD = 1000000007
    
    fun numOfArrays(n: Int, m: Int, k: Int): Int {
        if (m < k)
            return 0
        if (m == k)
            return 1

        // cost, maximum
        var nCases = Array(k + 1) { IntArray(m + 1) }
        (1..m).forEach {
            nCases[1][it] = 1
        }

        repeat(n - 1) {
            val newNCases = Array(k + 1) { IntArray(m + 1) }
            (1..m).forEach { candidate ->
                (1..k).forEach { cost ->
                    (1..m).forEach { maximum ->
                        if (candidate > maximum) {
                            if (cost < k) {
                                newNCases[cost + 1][candidate] += nCases[cost][maximum]
                                newNCases[cost + 1][candidate] %= MOD
                            }
                        } else {
                            newNCases[cost][maximum] += nCases[cost][maximum]
                            newNCases[cost][maximum] %= MOD
                        }
                    }
                }
            }
            nCases = newNCases
        }

        return nCases[k].fold(0) { acc, i -> (acc + i) % MOD }
    }
}