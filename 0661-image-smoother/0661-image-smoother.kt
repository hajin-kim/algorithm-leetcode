class Solution {
    fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
        val m = img.size
        val n = img[0].size

        val result = Array(m) { IntArray(n) }

        for (i in 0 until m) {
            for (j in 0 until n) {
                val cells = (i - 1..i + 1).flatMap { r ->
                    (j - 1..j + 1).map { c -> r to c }
                }
                    .filter { (r, c) -> r in 0 until m && c in 0 until n }

                result[i][j] = cells.sumOf { (r, c) -> img[r][c] } / cells.size
            }
        }

        return result
    }
}