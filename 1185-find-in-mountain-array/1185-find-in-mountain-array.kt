class Solution {
    private fun MountainArray.findTarget(left: Int, right: Int, target: Int, isUpside: Boolean): Int {
        @Suppress("NAME_SHADOWING") var left = left
        @Suppress("NAME_SHADOWING") var right = right
        while (left <= right) {
            val mid = (left + right) / 2
            val midValue = get(mid)
            if (midValue == target) {
                return mid
            }
            if (isUpside) {
                if (target > midValue) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            } else {
                if (target > midValue) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
        }
        return -1
    }

    private fun MountainArray.findPeak(): Int {
        var left = 0
        var right = length() - 1
        while (left < right) {
            val mid = (left + right) / 2
            if (get(mid) < get(mid + 1)) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }

    fun findInMountainArray(target: Int, mountainArr: MountainArray): Int {
        val peak = mountainArr.findPeak()

        val leftsideResult = mountainArr.findTarget(0, peak, target, true)
        if (leftsideResult != -1)
            return leftsideResult

        return mountainArr.findTarget(peak, mountainArr.length() - 1, target, false)
    }
}