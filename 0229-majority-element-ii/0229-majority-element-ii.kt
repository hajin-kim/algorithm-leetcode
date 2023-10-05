class Solution {
    fun majorityElement(nums: IntArray): List<Int> {
        val counts = hashMapOf<Int, Int>()
        for (num in nums) {
            counts[num] = (counts[num] ?: 0) + 1
        }

        val threshold = nums.size / 3
        val result = mutableListOf<Int>()

        for ((num, count) in counts) {
            if (count > threshold)
                result.add(num)
        }
        
        return result
    }
}