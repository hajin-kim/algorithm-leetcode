class Solution {
    private val MODULO = 1000000007

    fun numFactoredBinaryTrees(arr: IntArray): Int {
        val sortedArr = arr.sortedArray()
        val cache = sortedArr
            .associate { it.toLong() to 1 }
            .toMutableMap()

        for (i in sortedArr.indices) {
            for (j in 0..i) {
                val iValue = sortedArr[i].toLong()
                val jValue = sortedArr[j].toLong()
                val product = iValue * jValue

                if (product in cache) {
                    val orderFactor = if (i == j) 1L else 2L

                    val new = (orderFactor
                            * cache[iValue]!!
                            * cache[jValue]!!
                            + cache[product]!!) % MODULO
                    cache[product] = new.toInt()
                }
            }
        }

        return cache.values
            .fold(0) { acc, i -> (acc + i) % MODULO }
    }
}