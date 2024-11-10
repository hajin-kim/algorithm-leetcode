import java.util.ArrayDeque
import java.util.LinkedList
import java.util.Queue

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec {
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        if (root == null)
            return "[]"

        val result = mutableListOf<Int?>()

        val queue: Queue<TreeNode?> = LinkedList()
        queue += root

        var nonNullCount = 1
        while (queue.isNotEmpty() && nonNullCount > 0) {
            nonNullCount = 0
            repeat(queue.size) {
                val now = queue.poll()

                result += now?.`val`

                if (now == null) {
                    return@repeat
                }

                for (child in arrayOf(now.left, now.right)) {
                    queue.add(child)
                    if (child != null)
                        nonNullCount += 1
                }
            }
        }

        return result.joinToString(",", "[", "]")
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data == "[]")
            return null

        val dataList = data.slice(1 until data.lastIndex)
            .split(',')
            .map { it.toIntOrNull() }

        var pointer = 0
        val root = TreeNode(dataList[pointer++]!!)

        val queue: Queue<TreeNode> = ArrayDeque()
        queue += root

        while (queue.isNotEmpty() && pointer < dataList.size) {
            val now = queue.poll()

            val leftVal = dataList[pointer++]
            val rightVal = dataList[pointer++]

            if (leftVal != null) {
                val left = TreeNode(leftVal)
                now.left = left
                queue += left
            }

            if (rightVal != null) {
                val right = TreeNode(rightVal)
                now.right = right
                queue += right
            }
        }

        return root
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var ser = Codec()
 * var deser = Codec()
 * var data = ser.serialize(longUrl)
 * var ans = deser.deserialize(data)
 */
