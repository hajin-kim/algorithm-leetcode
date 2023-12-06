class Solution {
    private fun Int.sumFromOne(): Int =
        this * (this + 1) / 2

    private val sumOfWeek = 7.sumFromOne()

    fun totalMoney(n: Int): Int {
        var result = 0

        val weeks = n / 7
        result += (weeks - 1).sumFromOne() * 7 + weeks * sumOfWeek

        val remaining = n % 7
        result += weeks * remaining + remaining.sumFromOne()

        return result
    }
}