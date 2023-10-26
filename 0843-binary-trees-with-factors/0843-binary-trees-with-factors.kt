class Solution {
    private val MODULO = 1000000007

    fun numFactoredBinaryTrees(arr: IntArray): Int {
        val sortedArr = LongArray(arr.size) { arr[it].toLong() }
            .sortedArray()
        val cache = sortedArr
            .associateWith { 1L }
            .toMutableMap()

        for (i in sortedArr) {
            for (j in sortedArr) {
                val product = i * j

                if (product in cache) {
                    val orderFactor = if (i == j) 1 else 2

                    cache[product] = (orderFactor
                            * cache[i]!!
                            * cache[j]!!
                            + cache[product]!!)
                }

                if (i == j)
                    break
            }
        }

        return cache.values
            .fold(0L) { acc, i -> (acc + i) % MODULO }
            .toInt()
    }
}