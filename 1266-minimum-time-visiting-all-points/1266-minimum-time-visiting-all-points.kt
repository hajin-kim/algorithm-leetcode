import kotlin.math.abs

class Solution {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int =
        points
            .toList()
            .zipWithNext()
            .sumOf { (point1, point2) ->
                val (x1, y1) = point1
                val (x2, y2) = point2
                maxOf(abs(x1 - x2), abs(y1 - y2))
            }
}