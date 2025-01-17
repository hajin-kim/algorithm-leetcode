class Solution {
    fun singleNonDuplicate(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex
        
        while (left < right) {
            val mid = (left + right) / 2

            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]){
                    left = mid + 2
                } else {
                    right = mid
                }
            } else {
                if (nums[mid] != nums[mid + 1]) {
                    left = mid + 1
                }
                else {
                    right = mid - 1
                }
            }
        }

        return nums[right]
    }
}