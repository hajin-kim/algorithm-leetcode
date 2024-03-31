import java.util.LinkedList
import java.util.Queue

data class Point(
    val r: Int,
    val c: Int,
)

class Solution {
    private fun bfs(grid: Array<IntArray>): Int {
        val n = grid.size
        val start = Point(r = 0, c = 0)

        fun Point.isInRange(): Boolean =
            r in 0 until n && c in 0 until n

        fun Point.atEnd(): Boolean =
            r == n - 1 && c == n - 1

        val queue: Queue<Point> = LinkedList()
        val visited = Array(n) { BooleanArray(n) }

        queue.add(start)

        var distance = 1
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val point = queue.poll()
                val (r, c) = point

                if (visited[r][c])
                    return@repeat
                if (point.atEnd())
                    return distance
                visited[r][c] = true

                val neighbors = listOf(
                    1 to 1,
                    1 to 0,
                    1 to -1,
                    0 to 1,
                    0 to -1,
                    -1 to 1,
                    -1 to 0,
                    -1 to -1,
                )
                    .map { (dr, dc) -> Point(r + dr, c + dc) }
                    .filter { it.isInRange() && grid[it.r][it.c] == 0 }

                queue.addAll(neighbors)
            }
            ++distance
        }

        return -1
    }

    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        if (grid[0][0] == 1)
            return -1

        return bfs(grid)
    }
}
