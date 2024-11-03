import java.util.ArrayDeque
import java.util.Queue

class Solution {
    private fun String.distanceFrom(other: String): Int {
        var distance = 0
        for (i in indices) {
            if (this[i] != other[i])
                ++distance
        }
        return distance
    }

    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val n = wordList.size
        val distancesFromBegin = IntArray(n)
        val distancesFromEnd = IntArray(n)

        for (i in wordList.indices) {
            val word = wordList[i]
            val distanceFromBegin = word.distanceFrom(beginWord)
            val distanceFromEnd = word.distanceFrom(endWord)

            distancesFromBegin[i] = distanceFromBegin
            distancesFromEnd[i] = distanceFromEnd
        }

        val indicesByDistanceMap = distancesFromBegin.withIndex().groupBy({ it.value }, { it.index })

        val queue: Queue<Int> = ArrayDeque()
        queue += indicesByDistanceMap[1] ?: emptyList()
        val visited = mutableSetOf<String>()

        var score = 2
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val index = queue.poll()
                val distance = distancesFromBegin[index]
                val word = wordList[index]

                if (word in visited)
                    return@repeat
                visited += word

                if (word.distanceFrom(endWord) == 0)
                    return score

                for (nextDistance in arrayOf(distance - 1, distance, distance + 1)) {
                    val candidates = indicesByDistanceMap[nextDistance] ?: emptyList()
                    for (candidate in candidates) {
                        val candidateWord = wordList[candidate]
                        if (candidate != index && word.distanceFrom(candidateWord) == 1)
                            queue += candidate
                    }
                }
            }
            ++score
        }

        return 0
    }
}
