class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.lastIndex

        var maxArea = 0
        while (left < right) {
            val min = minOf(height[left], height[right])
            val area = min * (right - left)

            maxArea = maxOf(maxArea, area)

            if (height[left] > height[right])
                --right
            else
                ++left
        }
        
        return maxArea
    }
}
