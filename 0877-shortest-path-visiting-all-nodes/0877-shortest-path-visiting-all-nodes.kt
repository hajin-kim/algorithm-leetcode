import java.util.*

class Solution {
    private fun BooleanArray.bitMask(): Int {
        var result = 0
        forEachIndexed { index, b ->
            if (b) result = result or (1 shl index)
        }
        return result
    }

    private fun Int.setBit(index: Int): Int {
        return this or (1 shl index)
    }

    private fun Int.isSetAll(n: Int): Boolean {
        return this == (1 shl n) - 1
    }

    private fun bfs(start: Int, graph: Array<IntArray>): Int {
        val n = graph.size
        val initialState = BooleanArray(n)
            .apply { this[start] = true }
            .bitMask()

        // currentNode, state
        val visited = Array(n) { BooleanArray(1 shl n) }
        // node to state
        var queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
            .apply { add(start to initialState) }

        var count = 1
        while (queue.isNotEmpty()) {
            val toVisit = LinkedList<Pair<Int, Int>>()

            queue.forEach { (node, state) ->
                for (neighbor in graph[node]) {
                    val newState = state.setBit(neighbor)
                    if (newState.isSetAll(n))
                        return count

                    if (visited[neighbor][newState])
                        continue
                    visited[neighbor][newState] = true

                    toVisit.add(neighbor to newState)
                }
            }

            ++count
            queue = toVisit
        }

        return Int.MAX_VALUE
    }

    fun shortestPathLength(graph: Array<IntArray>): Int {
        if (graph.size == 1)
            return 0

        return (0 until graph.size).minOf { bfs(it, graph) }
    }
}