class Solution {
    private val Y = 0
    private val X = 1

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = ArrayList<Int>(matrix.size * matrix[0].size)

        // y, x
        val repeats = intArrayOf(matrix.size, matrix[0].size)
        val currents = intArrayOf(0, -1)
        var sign = 1
        var iRepeat = X

        while (repeats[Y] > 0 && repeats[X] > 0) {
            repeat(repeats[iRepeat]) {
                currents[iRepeat] += sign

                result += matrix[currents[Y]][currents[X]]
            }

            if (iRepeat == Y)
                sign *= -1
            iRepeat = 1 - iRepeat

            repeats[iRepeat] -= 1
        }

        return result
    }
}
