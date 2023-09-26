import java.util.*

class Solution {
    fun removeDuplicateLetters(s: String): String {
        val remaining = IntArray(26)
        val used = BooleanArray(26)
        val stack = Stack<Char>()

        for (it in s) {
            remaining[it - 'a']++
        }

        for (it in s) {
            val index = it - 'a'
            remaining[index]--

            if (used[index])
                continue

            while (stack.isNotEmpty()) {
                val last = stack.last()
                val lastIndex = last - 'a'
                if (last > it && remaining[lastIndex] > 0) {
                    stack.pop()
                    used[last - 'a'] = false
                } else break
            }

            stack.push(it)
            used[index] = true
        }

        return stack.joinToString("")
    }
}