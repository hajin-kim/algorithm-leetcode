import java.util.PriorityQueue

data class Point(
    val r: Int,
    val c: Int,
)

class Solution {
    private val UNVISITED = 1_000_000_000
    fun dijkstra(grid: Array<IntArray>): Int {
        val n = grid.size
        val start = Point(r = 0, c = 0)

        fun Point.isInRange(): Boolean =
            r in 0 until n && c in 0 until n

        val priorityQueue = PriorityQueue<Pair<Int, Point>>(compareBy { it.first })
        val visited = Array(n) { BooleanArray(n) }
        val distances = Array(n) { IntArray(n) { UNVISITED } }

        priorityQueue.add(1 to start)
        distances[0][0] = 1

        while (priorityQueue.isNotEmpty()) {
            val (cost, point) = priorityQueue.poll()
            val (r, c) = point

            if (visited[r][c])
                continue
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

            for (neighbor in neighbors) {
                val newCost = cost + 1
                if (newCost < distances[neighbor.r][neighbor.c]) {
                    distances[neighbor.r][neighbor.c] = newCost
                    priorityQueue.add(newCost to neighbor)
                }
            }
        }

        val endDistance = distances[n - 1][n - 1]
        return if (endDistance == UNVISITED) -1 else endDistance
    }

    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        if (grid[0][0] == 1)
            return -1

        return dijkstra(grid)
    }
}
