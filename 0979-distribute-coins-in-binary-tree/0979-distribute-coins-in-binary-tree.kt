import kotlin.math.absoluteValue

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
    fun distributeCoins(root: TreeNode?): Int {
        var result = 0

        fun TreeNode?.remainingCoins(): Int {
            if (this == null)
                return 0

            var remainingCoins = `val` - 1

            val leftCoins = left.remainingCoins()
            val rightCoins = right.remainingCoins()

            for (coins in listOf(leftCoins, rightCoins)) {
                result += coins.absoluteValue // don't consider if positive or negative
                remainingCoins += coins
            }

            return remainingCoins
        }

        root.remainingCoins()

        return result
    }
}
