import java.util.LinkedList
import java.util.Queue

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {
    fun connect(root: Node?): Node? {
        if (root == null)
            return root

        val queue: Queue<Node> = LinkedList()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val limit = queue.size
            repeat(limit) { i ->
                val node = queue.poll()
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }

                node.next = if (i == limit - 1) null else queue.peek()
            }
        }

        return root
    }
}
