class Solution {
    private val MODULO = (10e8 + 7).toInt()
    fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
        if (target < n)
            return 0

        val max = n * k + 1
        if (target >= max)
            return 0

        var cache = IntArray(max)
        for (die in 1..k)
            cache[die] = 1

        for (dice in 2..n) {
            val new = IntArray(max)
            for (die in 1..k) {
                for (case in 1..(dice * k)) {
                    val next = case + die
                    if (next < max) {
                        new[case + die] += cache[case]
                        new[case + die] %= MODULO
                    }
                }
            }
            cache = new
        }

        return cache[target]
    }
}