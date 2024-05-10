import java.util.PriorityQueue

class Solution {
    fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
        val priorityQueue = PriorityQueue<Pair<Int, Int>> { (a1, a2), (b1, b2) ->
            compareValues(arr[a1] * arr[b2], arr[a2] * arr[b1])
        }
        priorityQueue += (0 until arr.lastIndex).map { it to arr.lastIndex }

        repeat(k - 1) {
            val (left, right) = priorityQueue.poll()
            val nextRight = right - 1
            if (left < nextRight) {
                priorityQueue += left to nextRight
            }
        }

        val (left, right) = priorityQueue.poll()
        return intArrayOf(arr[left], arr[right])
    }
}
