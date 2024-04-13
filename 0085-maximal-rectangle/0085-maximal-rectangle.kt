import java.util.Stack

class Solution {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        val rows = matrix.size
        val cols = matrix[0].size

        // pad row with zeros to clear stack at last
        val maxOnes = Array(rows + 1) { IntArray(cols) }
        for (i in matrix.indices) {
            var ones = 0
            for (j in matrix[0].indices) {
                if (matrix[i][j] == '1')
                    ++ones
                else
                    ones = 0

                maxOnes[i][j] = ones
            }
        }

        var result = 0
        for (j in maxOnes[0].indices) {
            val stack = Stack<Pair<Int, Int>>()
            for (i in maxOnes.indices) {
                var width = 0
                while (stack.isNotEmpty() && maxOnes[stack.peek().first][j] >= maxOnes[i][j]) {
                    val (prevI, prevWidth) = stack.pop()

                    width += prevWidth

                    val area = maxOnes[prevI][j] * width
                    result = maxOf(result, area)

                }
                stack.push(i to width + 1)
            }
        }

        return result
    }
}
