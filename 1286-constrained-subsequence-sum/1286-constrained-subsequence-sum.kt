import java.util.*

class Solution {
    fun constrainedSubsetSum(nums: IntArray, k: Int): Int {
        val deque: Deque<Int> = LinkedList()

        for (i in nums.indices) {
            if (deque.isNotEmpty())
                nums[i] += nums[deque.peekFirst()]

            while (deque.isNotEmpty()) {
                if (nums[i] >= nums[deque.peekLast()])
                    deque.pollLast()
                else if (i - deque.peekFirst() >= k)
                    deque.pollFirst()
                else
                    break
            }

            if (nums[i] > 0) {
                deque.offerLast(i)
            }
        }

        return nums.max()
    }
}