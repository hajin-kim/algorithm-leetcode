import java.util.*

// topology sort
class Solution {
    fun minimumTime(n: Int, relations: Array<IntArray>, time: IntArray): Int {
        val relationMap = relations
            .groupBy { it[0] }
            .mapValues { (_, v) -> v.map { it[1] } }

        val remainingPrerequisites = IntArray(n + 1)
        for (relation in relations) {
            remainingPrerequisites[relation[1]]++
        }

        val requiredTimes = IntArray(n + 1)
        val queue: Queue<Int> = LinkedList()
        for (i in 1..n) {
            if (remainingPrerequisites[i] == 0) {
                requiredTimes[i] = time[i - 1]
                queue.add(i)
            }
        }

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            for (next in relationMap[node] ?: emptyList()) {
                remainingPrerequisites[next]--
                requiredTimes[next] = maxOf(requiredTimes[next], requiredTimes[node] + time[next - 1])
                if (remainingPrerequisites[next] == 0)
                    queue.add(next)
            }
        }

        return requiredTimes.max()
    }
}