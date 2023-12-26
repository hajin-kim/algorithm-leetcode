class Solution {
    private val MODULO = (10e8 + 7).toInt()
    fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
        if (target < n || target > n * k)
            return 0

        var cache = IntArray(target + 1)
        cache[0] = 1

        for (dice in 1..n) {
            val new = IntArray(target + 1)

            for (die in 1..k) {
                for (next in 1..target) {
                    val prev = next - die
                    if (prev >= 0) {
                        new[next] += cache[prev]
                        new[next] %= MODULO
                    }
                }
            }
            cache = new
        }

        return cache[target]
    }
}