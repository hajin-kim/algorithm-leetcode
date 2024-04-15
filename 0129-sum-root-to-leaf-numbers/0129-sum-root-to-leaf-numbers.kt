/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun sumNumbers(root: TreeNode?): Int {
        return root.sumNumbers(0)
    }

    private fun TreeNode?.sumNumbers(parentSum: Int): Int {
        this ?: return 0

        val sum = parentSum * 10 + `val`

        if (left == null && right == null)
            return sum

        return left.sumNumbers(sum) + right.sumNumbers(sum)
    }
}
