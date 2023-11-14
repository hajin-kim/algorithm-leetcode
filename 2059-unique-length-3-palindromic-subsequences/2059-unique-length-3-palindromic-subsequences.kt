class Solution {
    private fun Char.toIndex(): Int =
        this.code - 'a'.code

    fun countPalindromicSubsequence(s: String): Int {
        val foundPalindrome = Array(26) { BooleanArray(26) }

        for (char in 'a'..'z') {
            val left = s.indexOfFirst { it == char }
            if (left == -1)
                continue
            val right = s.indexOfLast { it == char }

            for (middle in left + 1 until right) {
                foundPalindrome[char.toIndex()][s[middle].toIndex()] = true
            }
        }

        return foundPalindrome.sumOf { middle -> middle.count { it } }
    }
}