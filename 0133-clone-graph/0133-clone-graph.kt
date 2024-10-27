/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {
    fun cloneGraph(node: Node?): Node? {
        val visited = mutableMapOf<Node, Node>()
        return node.clone(visited)
    }

    private fun Node?.clone(visited: MutableMap<Node, Node>): Node? {
        if (this == null)
            return null
        if (this in visited)
            return visited[this]

        val newNode = Node(`val`)
        visited += this to newNode

        for (neighbor in neighbors) {
            newNode.neighbors += neighbor.clone(visited)
        }
        return newNode
    }
}
