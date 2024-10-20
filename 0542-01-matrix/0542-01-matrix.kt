import java.util.ArrayDeque
import java.util.Queue

class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val queue: Queue<Pair<Int, Int>> = ArrayDeque()

        for (i in mat.indices) {
            for (j in mat[i].indices) {
                if (mat[i][j] == 0)
                    queue += i to j
            }
        }

        val result = Array(mat.size) { IntArray(mat[0].size) { Int.MAX_VALUE } }

        var distance = 0
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val (r, c) = queue.poll()
                if (result[r][c] < distance)
                    return@repeat

                result[r][c] = distance

                val neighbors = listOf(
                    r to c + 1,
                    r to c - 1,
                    r + 1 to c,
                    r - 1 to c,
                )
                for (neighbor in neighbors) {
                    val (nr, nc) = neighbor
                    if (nr in mat.indices && nc in mat[0].indices)
                        queue += neighbor
                }
            }

            ++distance
        }

        return result
    }
}
