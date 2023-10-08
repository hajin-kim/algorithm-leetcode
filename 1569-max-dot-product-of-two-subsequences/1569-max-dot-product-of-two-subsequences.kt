class Solution {
    val MIN = -1000000000
    fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {

        val cache = Array(nums1.size) { IntArray(nums2.size) { MIN } }
        fun dp(a: Int, b: Int): Int {
            if (a == -1 || b == -1)
                return MIN

            if (cache[a][b] != MIN)
                return cache[a][b]

            val result = maxOf(
                nums1[a] * nums2[b],
                dp(a - 1, b - 1) + nums1[a] * nums2[b],
                dp(a - 1, b),
                dp(a, b - 1),
            )
            cache[a][b] = result

            return result
        }

        return dp(nums1.size - 1, nums2.size - 1)
    }
}