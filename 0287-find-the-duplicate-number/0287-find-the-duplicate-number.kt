class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var min = 1
        var max = nums.size
        while (min != max) {
            val mid = (min + max) / 2
            var leftCount = 0
            val leftInterval = min..mid

            nums.forEach { if (it in leftInterval) leftCount++ }

            if (leftCount > mid - min + 1) {
                max = mid
            } else {
                min = mid + 1
            }
        }

        return min
    }
}