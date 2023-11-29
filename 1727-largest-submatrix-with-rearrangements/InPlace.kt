class Solution {
    fun largestSubmatrix(matrix: Array<IntArray>): Int {
        for (r in 1 until matrix.size) {
            for (c in matrix[0].indices) {
                if (matrix[r][c] == 1)
                    matrix[r][c] = matrix[r - 1][c] + 1
            }
        }

        var max = 0
        for (r in matrix.indices) {
            matrix[r].sortDescending()

            for (c in matrix[0].indices) {
                val width = c + 1
                val area = width * matrix[r][c]
                max = maxOf(max, area)
            }
        }

        return max
    }
}