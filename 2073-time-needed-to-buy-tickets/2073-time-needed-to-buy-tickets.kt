class Solution {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        val target = tickets[k]
        return tickets.mapIndexed { index: Int, ticket: Int ->
            minOf(ticket, if (index > k) target - 1 else target)
        }.sum()
    }
}
