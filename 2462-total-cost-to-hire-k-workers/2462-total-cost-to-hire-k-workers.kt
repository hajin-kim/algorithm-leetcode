import java.util.PriorityQueue

class Solution {
    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
        val firstPriorityQueue = PriorityQueue<Int>(candidates)
        val lastPriorityQueue = PriorityQueue<Int>(candidates)

        var nextFirst = 0
        var nextLast = costs.lastIndex

        fun addFirstCandidate() {
            if (nextFirst <= nextLast) {
                firstPriorityQueue.add(costs[nextFirst])
                ++nextFirst
            }
        }

        fun addLastCandidate() {
            if (nextFirst <= nextLast) {
                lastPriorityQueue.add(costs[nextLast])
                --nextLast
            }
        }

        var result = 0L
        fun hireFirst() {
            result += firstPriorityQueue.poll()
            addFirstCandidate()
        }

        fun hireLast() {
            result += lastPriorityQueue.poll()
            addLastCandidate()
        }

        repeat(candidates) {
            addFirstCandidate()
            addLastCandidate()
        }

        repeat(k) {
            if (firstPriorityQueue.isEmpty())
                hireLast()
            else if (lastPriorityQueue.isEmpty())
                hireFirst()
            else if (firstPriorityQueue.peek() <= lastPriorityQueue.peek())
                hireFirst()
            else
                hireLast()
        }

        return result
    }
}
