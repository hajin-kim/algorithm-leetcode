class Solution {
    private fun getPalindromeFrom(start: Int, end: Int, s: String, indices: IntRange): Pair<Int, Int> {
        var nextStart = start
        var nextEnd = end
        while (nextStart in indices &&
            nextEnd in indices &&
            s[nextStart] == s[nextEnd]
        ) {
            --nextStart
            ++nextEnd
        }

        return nextStart + 1 to nextEnd - 1
    }

    fun longestPalindrome(s: String): String {
        val indices = s.indices

        var maxRange = 0..0
        var maxLength = 1

        fun getPalindromeFrom(start: Int, end: Int) =
            getPalindromeFrom(start, end, s, indices)

        for (i in indices) {
            listOf(
                getPalindromeFrom(i, i),
                getPalindromeFrom(i, i + 1),
            ).forEach { (start, end) ->
                val length = end - start + 1
                if (length > maxLength) {
                    maxLength = length
                    maxRange = start..end
                }
            }

        }

        return s.slice(maxRange)
    }
}