class Solution {
    private fun IntArray.binarySearchStart(target: Int): Int {
        var left = 0
        var right = size - 1

        var found = -1

        while (left <= right) {
            val mid = (left + right) / 2

            if (get(mid) >= target) {
                right = mid - 1
                if (get(mid) == target)
                    found = mid
            } else
                left = mid + 1
        }

        return found
    }

    private fun IntArray.binarySearchEnd(target: Int): Int {
        var left = 0
        var right = size - 1

        var found = -1

        while (left <= right) {
            val mid = (left + right) / 2

            if (get(mid) <= target) {
                left = mid + 1
                if (get(mid) == target)
                    found = mid
            } else
                right = mid - 1
        }

        return found
    }

    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty())
            return intArrayOf(-1, -1)

        val start = nums.binarySearchStart(target)
        val end = nums.binarySearchEnd(target)

        return intArrayOf(start, end)
    }
}