import java.util.*

class Solution {
    fun find132pattern(nums: IntArray): Boolean {
        var min = Int.MAX_VALUE
        val ranges: Stack<IntRange> = Stack()

        for (num in nums) {
            if (ranges.any { num in it })
                return true

            min = minOf(min, num)
            if (num > min) {
                while (ranges.isNotEmpty() && ranges.peek().endExclusive < num) {
                    ranges.pop()
                }
                ranges.add(min + 1..<num)
            }
        }



        return false
    }
}