class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val START = 0
        val END = 1

        val n = intervals.size

        val index = let {
            val indexOrInsertionPoint = intervals.binarySearch(newInterval, compareBy { it[0] })
            if (indexOrInsertionPoint < 0)
                -indexOrInsertionPoint - 1
            else
                indexOrInsertionPoint
        }

        val result = mutableListOf<IntArray>()
        print(index)
        if (index > 0) {
            val front = intervals.slice(0 until index).toMutableList()
            while (front.isNotEmpty() && front.last()[END] >= newInterval[START]) {
                newInterval[START] = minOf(newInterval[START], front.last()[START])
                newInterval[END] = maxOf(newInterval[END], front.last()[END])
                front.removeLast()
            }
            result.addAll(front)
        }

        result.add(newInterval)

        if (index < n) {
            val back = intervals.slice(index until n).toMutableList()
            while (back.isNotEmpty() && result.last()[END] >= back[0][START]) {
                result.last()[START] = minOf(back[0][START], result.last()[START])
                result.last()[END] = maxOf(back[0][END], result.last()[END])
                back.removeFirst()
            }
            result.addAll(back)
        }

        return result.toTypedArray()
    }
}
