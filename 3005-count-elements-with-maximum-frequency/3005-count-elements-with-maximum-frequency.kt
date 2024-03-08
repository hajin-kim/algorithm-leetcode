class Solution {
    fun maxFrequencyElements(nums: IntArray): Int {
        val counts = IntArray(101)
        for (num in nums) {
            counts[num]++
        }
        
        counts.sortDescending()
        
        val max = counts[0]
        
        return counts.takeWhile { it == max }.sum()
    }
}
