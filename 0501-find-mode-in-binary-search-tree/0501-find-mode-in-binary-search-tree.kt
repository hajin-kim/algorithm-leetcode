class Solution {
    private val counter = mutableMapOf<Int, Int>()

    private fun TreeNode?.count() {
        if (this == null)
            return
        counter[this.`val`] = (counter[this.`val`] ?: 0) + 1
        left.count()
        right.count()
    }

    fun findMode(root: TreeNode?): IntArray {
        root.count()
        val max = counter.values.max()
        return counter
            .filter { (_, v) -> v == max }
            .keys
            .toIntArray()
    }
}
