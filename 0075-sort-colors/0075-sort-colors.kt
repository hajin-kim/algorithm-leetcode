class Solution {
    fun sortColors(nums: IntArray): Unit {
        val colors = IntArray(3)

        for (num in nums) {
            colors[num]++
        }

        var i = 0
        for (c in colors.indices) {
            val color = colors[c]
            repeat(color) {
                nums[i] = c
                i++
            }
        }
    }
}
