class Solution {
    fun findDuplicates(nums: IntArray): List<Int> {
        for (i in nums.indices) {
            var j = nums[i] - 1
            while (nums[i] != i + 1 && nums[i] != nums[j]) {
                val tmp = nums[j]
                nums[j] = nums[i]
                nums[i] = tmp

                j = nums[i] - 1
            }
        }

        return nums.filterIndexed { i, num -> num != i + 1 }
    }
}
