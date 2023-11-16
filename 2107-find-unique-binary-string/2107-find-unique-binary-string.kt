class Solution {
    fun findDifferentBinaryString(nums: Array<String>): String =
        buildString {
            for (i in nums.indices) {
                append(if (nums[i][i] == '0') '1' else '0')
            }
        }
}