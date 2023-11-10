class Solution {
    private val NOT_FOUND = Int.MAX_VALUE
    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
        val n = adjacentPairs.size + 1

        val adjacentMap = mutableMapOf<Int, IntArray>()

        for ((first, second) in adjacentPairs) {
            for ((left, right) in listOf(
                first to second,
                second to first
            )) {
                if (left in adjacentMap) {
                    adjacentMap[left]!![1] = right
                } else {
                    adjacentMap[left] = intArrayOf(right, NOT_FOUND)
                }
            }
        }

        val start = adjacentMap
            .entries
            .first { (_, v) -> v[1] == NOT_FOUND }
            .key

        val result = IntArray(n)

        var prev = start
        var now = adjacentMap[start]!![0]

        result[0] = prev
        result[1] = now

        for (i in 2 until n) {
            val next = adjacentMap[now]!!.first { candidate -> candidate != prev }
            result[i] = next

            prev = now
            now = next
        }

        return result
    }
}