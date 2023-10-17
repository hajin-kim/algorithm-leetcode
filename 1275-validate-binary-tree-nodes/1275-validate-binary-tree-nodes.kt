import java.util.*

class Solution {
    fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
        val parents = IntArray(n) { -1 }

        fun bfsCheckCycle(start: Int): Boolean {
            val queue: Queue<Int> = LinkedList()
            queue.add(start)
            parents[start] = start

            while (queue.isNotEmpty()) {
                val node = queue.poll()

                listOf(
                    leftChild[node],
                    rightChild[node]
                ).forEach { next ->
                    if (next == -1)
                        return@forEach

                    if (parents[next] == start)
                        return false
                    if (parents[next] == next) {
                        parents[next] = start
                        return@forEach
                    }

                    parents[next] = start
                    queue.add(next)
                }
            }

            return true
        }

        for (node in 0 until n) {
            if (parents[node] == -1)
                if (!bfsCheckCycle(node))
                    return false
        }

        var count = 0
        for (i in 0 until n) {
            if (parents[i] == i)
                ++count

            if (count > 1)
                return false
        }
        return count == 1
    }
}