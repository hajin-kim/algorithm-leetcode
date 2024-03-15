class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size

        val prefixOf = IntArray(n)
        prefixOf[0] = 1
        for (i in 1 until n) {
            prefixOf[i] = prefixOf[i - 1] * nums[i - 1]
        }

        val suffixOf = IntArray(n)
        suffixOf[nums.lastIndex] = 1
        for (i in n - 2 downTo 0) {
            suffixOf[i] = suffixOf[i + 1] * nums[i + 1]
        }

        return IntArray(n) { i -> prefixOf[i] * suffixOf[i] }
    }
}
