class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var result = 0
        var left = 0
        val set = mutableSetOf<Char>()

        for (right in s.indices) {
            val char = s[right]
            while (char in set) {
                set -= s[left]
                ++left
            }
            set += char
            result = maxOf(result, (right + 1) - left)
        }

        return result
    }
}
