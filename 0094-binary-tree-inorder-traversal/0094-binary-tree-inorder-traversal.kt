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
    private fun TreeNode?.inorder(mutableResult: MutableList<Int>) {
        if (this == null)
            return

        left.inorder(mutableResult)

        mutableResult.add(this.`val`)

        right.inorder(mutableResult)
    }

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val mutableResult = mutableListOf<Int>()
        root.inorder(mutableResult)

        return mutableResult
    }
}