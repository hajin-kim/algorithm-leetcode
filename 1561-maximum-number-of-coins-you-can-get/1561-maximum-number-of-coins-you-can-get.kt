class Solution {
    fun maxCoins(piles: IntArray): Int {
        val n = piles.size / 3

        piles.sort()

        var result = 0
        repeat(n) {
            result += piles[n + it * 2]
        }

        return result
    }
}