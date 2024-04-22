import java.util.LinkedList
import java.util.Queue

class Solution {
    private fun Char.neighbors(): List<Char> {
        val candidates = listOf(this + 1, this - 1)
        return candidates.map {
            if (it < '0')
                '9'
            else if (it > '9')
                '0'
            else it
        }
    }

    private val neighborsMap = ('0'..'9').associateWith { it.neighbors() }

    private fun String.neighbors(): List<String> {
        return (0..3)
            .flatMap { i ->
                neighborsMap[this[i]]!!.map {
                    this.slice(0..(i - 1)) + it + this.slice((i + 1)..3)
                }
            }
    }

    fun openLock(deadends: Array<String>, target: String): Int {
        @Suppress("NAME_SHADOWING")
        val deadends = deadends.toSet()

        val visited = hashSetOf<String>()
        val queue: Queue<String> = LinkedList()
        queue.add("0000")

        var steps = 0
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val now = queue.poll()

                if (now == target)
                    return steps

                if (now in deadends)
                    return@repeat
                if (now in visited)
                    return@repeat
                visited += now

                queue += now.neighbors()
            }
            ++steps
        }

        return -1
    }
}
