class Solution {
    private val MODULO = (1e9 + 7).toInt()

    fun numberOfWays(corridor: String): Int {
        val seatIndices = corridor
            .withIndex()
            .filter { it.value == 'S' }
            .map { it.index }

        if (seatIndices.size < 2 || seatIndices.size % 2 == 1)
            return 0

        return seatIndices
            .drop(1)
            .windowed(2, 2)
            .fold(1L) { acc, (previousEnd, nextStart) ->
                acc * (nextStart - previousEnd) % MODULO
            }
            .toInt()
    }
}