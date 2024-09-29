class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val first = nums.first()
        val last = nums.last()

        if (first <= last) {
            return nums.binarySearch(target).coerceAtLeast(-1)
        }
        if (target in (last + 1) until first) {
            return -1
        }

        val shouldFindLeft = target > last

        var low = 0
        var high = nums.lastIndex

        while (low <= high) {
            val mid = (low + high) ushr 1
            val midVal: Int = nums[mid]

            if (!shouldFindLeft && midVal > last) {
                low = mid + 1
            } else if (shouldFindLeft && midVal < first) {
                high = mid - 1
            } else if (midVal < target) {
                low = mid + 1
            } else if (midVal > target) {
                high = mid - 1
            } else return mid
        }

        return -1
    }
}
