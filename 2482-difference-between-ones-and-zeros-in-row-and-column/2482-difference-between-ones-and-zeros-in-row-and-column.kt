class Solution {
    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
        val m = grid.size
        val n = grid[0].size

        val onesRow = IntArray(m)
        val onesCol = IntArray(n)

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1) {
                    onesRow[i]++
                    onesCol[j]++
                }
            }
        }

        val diff = Array(m) { i ->
            IntArray(n) { j ->
                val zerosRow = m - onesRow[i]
                val zerosCol = n - onesCol[j]

                onesRow[i] + onesCol[j] - zerosRow - zerosCol
            }
        }

        return diff
    }
}