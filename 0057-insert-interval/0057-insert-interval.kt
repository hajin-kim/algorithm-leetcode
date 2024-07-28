class Solution {
    private val START = 0
    private val END = 1

    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val sorted = mutableListOf<IntArray>()

        var inserted = false
        for (interval in intervals) {
            if (!inserted && newInterval[START] <= interval[START]) {
                sorted += newInterval
                inserted = true
            }
            sorted += interval
        }
        if (!inserted)
            sorted += newInterval

        val result = mutableListOf<IntArray>()
        for (i in sorted.indices) {
            val interval = sorted[i]

            if (i < sorted.lastIndex && sorted[i + 1][START] <= interval[END]) {
                val next = sorted[i + 1]
                next[START] = interval[START]
                next[END] = maxOf(interval[END], next[END])
            } else
                result += interval
        }

        return result.toTypedArray()
    }
}
