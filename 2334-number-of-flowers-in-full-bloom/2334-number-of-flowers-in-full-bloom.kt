import java.util.*

class Solution {
    fun fullBloomFlowers(flowers: Array<IntArray>, people: IntArray): IntArray {
        val (starts, ends) = flowers.map { it[0] to it[1] }.unzip()

        val startQueue: Queue<Int> = starts.sorted().toCollection(LinkedList())
        val endQueue: Queue<Int> = ends.sorted().toCollection(LinkedList())

        var currentFlowers = 0

        return people
            .withIndex()
            .sortedBy { it.value }
            .map { (index, at) ->
                while (startQueue.isNotEmpty() && startQueue.peek() <= at) {
                    startQueue.poll()
                    currentFlowers++
                }

                while (endQueue.isNotEmpty() && endQueue.peek() < at) {
                    endQueue.poll()
                    currentFlowers--
                }

                IndexedValue(index, currentFlowers)
            }
            .sortedBy { it.index }
            .map { it.value }
            .toIntArray()
    }
}