import java.util.PriorityQueue

class Solution {
    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        val indices = startTime.indices.sortedBy { startTime[it] }

        val maxAndAvailableAt = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

        var localMax = 0
        for (i in indices) {
            val start = startTime[i]
            val end = endTime[i]

            while (maxAndAvailableAt.isNotEmpty() && maxAndAvailableAt.peek().second <= start) {
                localMax = maxOf(maxAndAvailableAt.poll().first, localMax)
            }

            maxAndAvailableAt += localMax + profit[i] to end
        }

        return maxAndAvailableAt.maxOf { it.first }
    }
}
