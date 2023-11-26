class Solution {
    fun largestSubmatrix(matrix: Array<IntArray>): Int {
        val prefixSums = Array(matrix.size) { IntArray(matrix[0].size) }

        prefixSums[0] = matrix[0].copyOf()
        for (r in 1 until matrix.size) {
            for (c in matrix[0].indices) {
                if (matrix[r][c] == 1)
                    prefixSums[r][c] = prefixSums[r - 1][c] + 1
            }
        }

        var max = 0
        for (r in matrix.indices) {
            prefixSums[r].sortDescending()

            for (c in matrix[0].indices) {
                val width = c + 1
                val area = width * prefixSums[r][c]
                max = maxOf(max, area)
            }
        }

        return max
    }
}