class Solution {
    private val parentTable = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0),
    )

    private fun zeroIndexedKthGrammar(n: Int, k: Int): Int {
        if (n <= 1)
            return k

        val parent = zeroIndexedKthGrammar(n - 1, k / 2)
        val leftThenZero = k % 2
        return parentTable[parent][leftThenZero]
    }

    fun kthGrammar(n: Int, k: Int): Int =
        zeroIndexedKthGrammar(n - 1, k - 1)
}