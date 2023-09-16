import java.util.*
import kotlin.math.abs

class Solution {
    data class Cell(val y: Int, val x: Int, val effort: Int)

    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val height = heights.size
        val width = heights[0].size

        val visited = Array(height) { BooleanArray(width) }
        var result = 0

        val priorityQueue = PriorityQueue<Cell>(compareBy { it.effort })
        priorityQueue.add(Cell(0, 0, 0))
        while (true) {
            val (y, x, effort) = priorityQueue.poll()

            if (visited[y][x])
                continue
            visited[y][x] = true

            result = maxOf(result, effort)

            if (y == height - 1 && x == width - 1)
                break

            listOf(
                y - 1 to x,
                y + 1 to x,
                y to x - 1,
                y to x + 1,
            ).forEach { (ny, nx) ->
                if (ny !in 0 until height || nx !in 0 until width)
                    return@forEach

                val nextEffort = abs(heights[ny][nx] - heights[y][x])
                priorityQueue.add(Cell(ny, nx, nextEffort))
            }
        }

        return result
    }
}