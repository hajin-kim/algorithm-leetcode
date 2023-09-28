class Solution {
    fun sortArrayByParity(nums: IntArray): IntArray {
        val deque = ArrayDeque<Int>(nums.size)

        for (number in nums) {
            if (number % 2 == 0)
                deque.addFirst(number)
            else
                deque.addLast(number)
        }

        return deque.toIntArray()
    }
}