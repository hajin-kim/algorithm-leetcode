import kotlin.math.absoluteValue

class Solution {
    private fun manhattanDistance(a: IntArray, b: IntArray): Int {
        return (a[0] - b[0]).absoluteValue + (a[1] - b[1]).absoluteValue
    }

    private fun prim(n: Int, edges: Array<IntArray>): Int {
        val visited = BooleanArray(n)
        val distances = IntArray(n) { Int.MAX_VALUE }
        distances[0] = 0

        var result = 0
        repeat(n) {
            val (nearestNode, nearestDistance) = distances.withIndex().filter { !visited[it.index] }.minBy { it.value }
            visited[nearestNode] = true
            result += nearestDistance

            (0 until n).forEach { i ->
                if (!visited[i] && distances[i] > edges[nearestNode][i])
                    distances[i] = edges[nearestNode][i]
            }
        }

        return result
    }

    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val n = points.size

        val manhattanDistances = Array(n) { a -> IntArray(n) { b -> manhattanDistance(points[a], points[b]) } }

        return prim(n, manhattanDistances)
    }
}
