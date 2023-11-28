class Solution {
    private val MODULO = (1e9 + 7).toInt()

    fun numberOfWays(corridor: String): Int {
        val seatIndices = corridor
            .withIndex()
            .filter { it.value == 'S' }
            .map { it.index }
            .toIntArray()

        if (seatIndices.size < 2 || seatIndices.size % 2 == 1)
            return 0

        var result = 1L
        for (i in 1 until seatIndices.size / 2) {
            val nextStart = i * 2
            val previousEnd = nextStart - 1

            result *= seatIndices[nextStart] - seatIndices[previousEnd]
            result %= MODULO
        }

        return result.toInt()
    }
}