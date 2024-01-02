class Solution {
    fun findMatrix(nums: IntArray): List<List<Int>> {
        val n = nums.size
        val counts = IntArray(n + 1)


        for (num in nums) {
            counts[num]++
        }

        val max = counts.max()
        val result = MutableList(max) { ArrayList<Int>() }

        for (num in counts.indices) {
            val count = counts[num]
            for (i in 0 until count) {
                result[i].add(num)
            }
        }

        return result
    }
}