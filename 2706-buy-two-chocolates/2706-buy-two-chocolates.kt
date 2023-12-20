class Solution {
    fun buyChoco(prices: IntArray, money: Int): Int {
        val two = prices.sorted().take(2).sum()
        return if (two > money)
            money
        else
            money - two
    }
}