class Solution {
    fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        val countMap = hashMapOf<Int, Int>()
        var ks = 0
        var result = 0

        var left = 0
        for (right in nums.indices) {
            val now = nums[right]
            val nowCount = countMap.getOrDefault(now, 0) + 1
            countMap[now] = nowCount

            if (nowCount > k)
                --ks
            else if (nowCount == 1)
                ++ks

            while (countMap.size != ks && left < right) {
                val popped = nums[left]
                val poppedCount = countMap[popped]!! - 1
                if (poppedCount == 0) {
                    --ks
                    countMap.remove(popped)
                } else {
                    countMap[popped] = poppedCount
                    if (poppedCount == k)
                        ++ks
                }

                ++left
            }

            if (countMap.size == ks) {
                val length = right - left + 1
                result = maxOf(result, length)
            }
        }

        return result
    }
}
