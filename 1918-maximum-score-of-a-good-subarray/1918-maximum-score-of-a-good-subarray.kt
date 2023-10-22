import java.util.*

class Solution {
    fun maximumScore(nums: IntArray, k: Int): Int {
        val stack = Stack<Pair<Int, Int>>()

        var score = 0
        for (i in 0..nums.size) {
            var left = i
            while (stack.isNotEmpty() &&
                (i == nums.size || // pop all remaining elements
                        nums[stack.peek().second] > nums[i])
            ) {
                val (poppedLeft, poppedMinIndex) = stack.pop()
                if (k in poppedLeft..(i - 1))
                    score = maxOf(score, nums[poppedMinIndex] * (i - poppedLeft))
                left = poppedLeft
            }
            stack.push(left to i)
        }

        return score
    }
}