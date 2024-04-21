import java.util.LinkedList
import java.util.Queue

class Solution {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val edgeMap = hashMapOf<Int, MutableList<Int>>()

        for ((a, b) in edges) {
            edgeMap.getOrPut(a) { mutableListOf() }.add(b)
            edgeMap.getOrPut(b) { mutableListOf() }.add(a)
        }

        val queue: Queue<Int> = LinkedList()
        val visited = BooleanArray(n)
        queue.add(source)

        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val now = queue.poll()

                if (now == destination)
                    return true

                if (visited[now])
                    return@repeat
                visited[now] = true

                val neighbors = edgeMap[now] ?: return@repeat
                queue.addAll(neighbors)
            }
        }

        return false
    }
}
