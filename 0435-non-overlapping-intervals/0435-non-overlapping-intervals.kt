import java.util.PriorityQueue

class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        val n = intervals.size

        val priorityQueue = PriorityQueue<IntArray>(n, compareBy { it[1] })
        priorityQueue += intervals

        var bar = Int.MIN_VALUE
        var result = n


        repeat(n) {
            val (start, end) = priorityQueue.poll()
            if (start >= bar) {
                bar = end
                --result
            }
        }

        return result
    }
}
