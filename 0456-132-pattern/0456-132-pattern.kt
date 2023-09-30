import java.util.*

class Solution {
    fun find132pattern(nums: IntArray): Boolean {
        var two = Int.MIN_VALUE
        val decreasingStack: Stack<Int> = Stack()

        for (i in nums.indices.reversed()) {
            val num = nums[i]
            if (num < two)
                return true

            while (decreasingStack.isNotEmpty() && decreasingStack.peek() < num) {
                two = decreasingStack.pop()
            }
            decreasingStack.push(num)
        }

        return false
    }
}
