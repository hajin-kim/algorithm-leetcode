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
    fun isValidBST(root: TreeNode?): Boolean {
        return root.isInRange(Long.MIN_VALUE, Long.MAX_VALUE)
    }

    private fun TreeNode?.isInRange(min: Long, max: Long): Boolean {
        this ?: return true

        if (`val` !in (min + 1)..<max)
            return false

        return left.isInRange(min, `val`.toLong()) && right.isInRange(`val`.toLong(), max)
    }
}
