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
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        return root.sumOfLeftLeaves(false)
    }

    private fun TreeNode?.sumOfLeftLeaves(isLeft: Boolean): Int {
        if (this == null)
            return 0
        if (left == null && right == null) {
            return if (isLeft) this.`val` else 0
        }
        return this.left.sumOfLeftLeaves(true) + this.right.sumOfLeftLeaves(false)
    }
}
