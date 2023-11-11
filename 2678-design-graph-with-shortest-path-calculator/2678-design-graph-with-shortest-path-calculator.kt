import java.util.PriorityQueue

class Graph(private val n: Int, edges: Array<IntArray>) {
    private val edgesArray = Array(n) { mutableListOf<Pair<Int, Int>>() }

    init {
        edges.forEach {
            addEdge(it)
        }
    }

    fun addEdge(edge: IntArray) {
        val (from, to, cost) = edge
        edgesArray[from].add(to to cost)
    }

    private fun dijkstra(start: Int): IntArray {
        val visited = BooleanArray(n)
        val distances = IntArray(n) { UNREACHABLE }
        val priorityQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

        priorityQueue.offer(start to 0)
        distances[start] = 0

        while (priorityQueue.isNotEmpty()) {
            val (now, nowDistance) = priorityQueue.poll()

            if (visited[now])
                continue
            visited[now] = true

            val neighbors = edgesArray[now]

            for ((neighbor, cost) in neighbors) {
                val newDistance = nowDistance + cost

                if (newDistance < distances[neighbor]) {
                    distances[neighbor] = newDistance
                    priorityQueue.offer(neighbor to newDistance)
                }
            }
        }

        return distances
    }

    fun shortestPath(node1: Int, node2: Int): Int {
        val distance = dijkstra(node1)[node2]
        return if (distance == UNREACHABLE)
            -1
        else distance
    }

    companion object {
        private const val UNREACHABLE = 1000000000
    }
}
