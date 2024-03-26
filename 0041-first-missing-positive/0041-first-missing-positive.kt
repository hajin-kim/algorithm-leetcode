class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size
        val indices = nums.indices

        for (i in indices) {
            val inPlaceNumber = i + 1
            var j = nums[i] - 1
            while (nums[i] != inPlaceNumber && j in indices) {
                if (nums[i] == nums[j])
                    nums[i] = -1

                val tmp = nums[j]
                nums[j] = nums[i]
                nums[i] = tmp

                j = nums[i] - 1
            }
        }

        for (i in indices) {
            val inPlaceNumber = i + 1
            if (nums[i] != inPlaceNumber)
                return inPlaceNumber
        }

        return n + 1
    }
}
