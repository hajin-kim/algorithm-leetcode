import java.util.LinkedList
import java.util.Queue

class Solution {
    fun findDifferentBinaryString(nums: Array<String>): String {
        val n = nums.size

        val result = StringBuilder(n)
        val queue: Queue<String> = LinkedList()
        queue.addAll(nums)

        for (i in nums.indices) {
            var ones = 0
            for (string in queue) {
                if (string[i] == '1')
                    ones++
            }

            if (ones == 0) {
                result.append("1".repeat(n - i))
                break
            } else if (ones == queue.size) {
                result.append("0".repeat(n - i))
                break
            }

            val selector = if (ones > n / 2) '0' else '1'
            repeat(queue.size) {
                val now = queue.poll()
                if (now[i] == selector)
                    queue.add(now)
            }
            result.append(selector)
        }

        return result.toString()
    }
}