class Solution {
    fun findDuplicate(nums: IntArray): Int {
        val n = nums.size

        var min = 1
        var max = n
        while (min != max) {
            val mid = (min + max) / 2
            var (leftCount, rightCount) = 0 to 0
            val leftInterval = min..mid
            val rightInterval = mid + 1..max
            for (i in 0 until n) {
                if (nums[i] in leftInterval) leftCount++
                if (nums[i] in rightInterval) rightCount++
            }
            if (leftCount > leftInterval.count()) {
                max = mid
            } else {
                min = mid + 1
            }
        }

        return min
    }
}