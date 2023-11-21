const val MODULO = 1000000007

class Combination(n: Int, r: Int) {
    private val UNDEFINED = -1

    private var cache = Array(n + 1) { IntArray(r + 1) { UNDEFINED } }

    fun combinationModulo(n: Int, r: Int): Int {
        if (n == 0)
            return 0
        if (r == 0 || r == n)
            return 1

        if (cache[n][r] != UNDEFINED)
            return cache[n][r]

        val result = (combinationModulo(n - 1, r) + combinationModulo(n - 1, r - 1)) % MODULO
        cache[n][r] = result

        return result
    }
}

class Solution {
    private fun Int.rev(): Int {
        var from = this
        var result = 0

        while (from > 0) {
            result *= 10
            result += from % 10
            from /= 10
        }

        return result
    }

    fun countNicePairs(nums: IntArray): Int {
        val numMinusRevs = nums.map { it - it.rev() }

        val countByNumMinusRev = mutableMapOf<Int, Int>()
        for (numMinusRev in numMinusRevs) {
            countByNumMinusRev[numMinusRev] = countByNumMinusRev.getOrDefault(numMinusRev, 0) + 1
        }

        val combination = Combination(countByNumMinusRev.values.max(), 2)

        return countByNumMinusRev
            .entries
            .fold(0) { acc, (_, count) ->
                if (count > 1)
                    (acc + combination.combinationModulo(count, 2)) % MODULO
                else
                    acc
            }
    }
}