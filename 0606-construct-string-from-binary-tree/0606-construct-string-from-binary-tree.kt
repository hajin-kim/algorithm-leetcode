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
    private fun TreeNode?.preorder(mutableResult: StringBuilder) {
        if (this == null)
            return

        mutableResult.append(`val`)

        if (left == null && right == null)
            return

        mutableResult.append('(')
        left.preorder(mutableResult)
        mutableResult.append(')')

        if (right == null)
            return

        mutableResult.append('(')
        right.preorder(mutableResult)
        mutableResult.append(')')
    }

    fun tree2str(root: TreeNode?): String {
        val mutableResult = StringBuilder()
        root.preorder(mutableResult)
        return mutableResult.toString()
    }
}