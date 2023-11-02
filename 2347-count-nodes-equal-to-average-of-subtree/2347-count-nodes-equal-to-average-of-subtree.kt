class Solution {
    private var result = 0

    private fun TreeNode?.count(): Pair<Int, Int> {
        if (this == null)
            return 0 to 0

        var count = 1
        var sum = `val`

        listOf(
            left.count(),
            right.count(),
        ).forEach { (subSum, subCount) ->
            sum += subSum
            count += subCount
        }

        if (`val` == sum / count)
            ++result

        return sum to count
    }

    fun averageOfSubtree(root: TreeNode?): Int {
        root.count()
        return result
    }
}