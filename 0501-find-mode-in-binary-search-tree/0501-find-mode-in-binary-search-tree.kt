class Solution {
    private fun morris(root: TreeNode): MutableList<Int> {
        var currentStreak = 0
        var currentVal = Int.MIN_VALUE
        var maxStreak = 0
        val result = mutableListOf<Int>()

        var current: TreeNode? = root
        while (current != null) {
            if (current.left != null) {
                // connect rightmost leaf of left subtree to current
                // disconnect and move to left child

                var prev = current.left!!
                while (prev.right != null) {
                    prev = prev.right!!
                }

                prev.right = current

                val toVisit = current.left
                current.left = null
                current = toVisit
            } else {
                // count mode and traverse

                if (current.`val` == currentVal) {
                    ++currentStreak
                } else {
                    currentStreak = 1
                    currentVal = current.`val`
                }

                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak
                    result.clear()
                    result.add(currentVal)
                } else if (currentStreak == maxStreak) {
                    result.add(currentVal)
                }

                current = current.right
            }
        }

        return result
    }

    fun findMode(root: TreeNode?): IntArray {
        if (root == null)
            return IntArray(0)

        return morris(root).toIntArray()
    }
}
