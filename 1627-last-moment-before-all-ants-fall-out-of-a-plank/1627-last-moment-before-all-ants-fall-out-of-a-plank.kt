class Solution {
    fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int = maxOf(
        left.maxOrNull() ?: 0,
        n - (right.minOrNull() ?: n),
    )
}