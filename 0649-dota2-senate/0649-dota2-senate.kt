import java.util.Queue
import java.util.ArrayDeque

class Solution {
    fun predictPartyVictory(senate: String): String {
        val queue: Queue<Boolean> = ArrayDeque(senate.length)

        senate.forEach {
            queue.add(it == 'R')
        }

        var r = queue.count { it }
        var d = senate.length - r

        var zombieR = 0
        var zombieD = 0

        while (r > 0 && d > 0) {
            val isR = queue.poll()

            if (isR) {
                if (zombieR > 0)
                    --zombieR
                else {
                    --d
                    ++zombieD
                    queue.add(isR)
                }
            } else {
                if (zombieD > 0)
                    --zombieD
                else {
                    --r
                    ++zombieR
                    queue.add(isR)
                }
            }
        }

        return if (r == 0) "Dire" else "Radiant"
    }
}