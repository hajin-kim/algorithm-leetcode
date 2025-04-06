class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val n = s.length
        val isPossible = BooleanArray(n)
        isPossible[0] = true

        for (i in 0 until n) {
            if (!isPossible[i]) {
                continue
            }

            for (word in wordDict) {
                val end = i + word.length
                if (end > n) {
                    continue
                }
                if (s.substring(i, end) != word) {
                    continue
                }

                if (end == n) {
                    return true
                }
                isPossible[end] = true
            }
        }

        return false
    }
}
