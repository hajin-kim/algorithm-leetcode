class Solution {
    fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
        val n = grid.size
        val result = Array(n - 2) { IntArray(n - 2) }

        for (i in 0 until n - 2) {
            for (j in 0 until n - 2) {
                for (r in i until i + 3) {
                    for (c in j until j + 3) {
                        result[i][j] = maxOf(result[i][j], grid[r][c])
                    }
                }
            }
        }
        
        return result
    }
}
