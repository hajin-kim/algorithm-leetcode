class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if (nums2.size < nums1.size)
            return findMedianSortedArrays(nums2, nums1)

        fun getMedianOf(a: Int, b: Int): Double {
            return if ((nums1.size + nums2.size) % 2 == 0)
                (a + b) / 2.0
            else
                maxOf(a, b).toDouble()
        }

        var left1 = 0
        var right1 = nums1.size

        while (true) {
            val mid1 = (left1 + right1) / 2
            val mid2 = (nums1.size + nums2.size) / 2 - mid1

            val maxOfMins1 = if (mid1 == 0) Int.MIN_VALUE else nums1[mid1 - 1]
            val minOfMaxs1 = if (mid1 == nums1.size) Int.MAX_VALUE else nums1[mid1]
            val maxOfMins2 = if (mid2 == 0) Int.MIN_VALUE else nums2[mid2 - 1]
            val minOfMaxs2 = if (mid2 == nums2.size) Int.MAX_VALUE else nums2[mid2]

            if (maxOfMins1 <= minOfMaxs2 && maxOfMins2 <= minOfMaxs1) {
                return getMedianOf(maxOf(maxOfMins1, maxOfMins2), minOf(minOfMaxs1, minOfMaxs2))
            }

            if (maxOfMins1 > minOfMaxs2) {
                right1 = mid1 - 1
            } else {
                left1 = mid1 + 1
            }
        }
    }
}