import java.util.*

class Solution {
    fun largestValues(root: TreeNode?): List<Int> {
        if (root == null)
            return emptyList()

        val largestValues = ArrayList<Int>()

        val row: Queue<TreeNode> = LinkedList()
        row.add(root)

        while (row.isNotEmpty()) {
            var largest = Int.MIN_VALUE

            repeat(row.size) {
                val node = row.poll()
                largest = maxOf(largest, node.`val`)

                if (node.left != null)
                    row.add(node.left!!)
                if (node.right != null)
                    row.add(node.right!!)
            }

            largestValues.add(largest)
        }

        return largestValues
    }
}