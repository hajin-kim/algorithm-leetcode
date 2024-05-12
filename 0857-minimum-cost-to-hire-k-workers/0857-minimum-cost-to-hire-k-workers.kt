import java.util.PriorityQueue

class Solution {
    fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {
        val n = quality.size

        val rates = DoubleArray(n) { wage[it].toDouble() / quality[it] }

        val qualityPriorityQueue = PriorityQueue<Int>(k, reverseOrder())

        val indices = (0 until n)
            .sortedWith(compareBy<Int> { rates[it] }.thenBy { wage[it] })
            .toIntArray()

        var result = Double.MAX_VALUE
        var sumQuality = 0

        for (i in 0 until n) {
            val now = indices[i]

            qualityPriorityQueue += quality[now]
            sumQuality += quality[now]

            if (i >= k - 1) {
                val cost = rates[now] * sumQuality
                result = minOf(result, cost)

                val currentMaxQuality = qualityPriorityQueue.poll()
                sumQuality -= currentMaxQuality
            }
        }

        return result
    }
}
