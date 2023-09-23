class Solution {
    fun isChain(short: String, long: String): Boolean {
        if (short.length + 1 != long.length) {
            throw IllegalArgumentException()
        }

        var isInserted = false
        long.forEachIndexed { index, c ->
            val shortIndex = if (isInserted) index - 1 else index

            if (!isInserted && shortIndex == short.length) {
                return true
            }

            if (c != short[shortIndex]) {
                if (isInserted) {
                    return false
                }
                isInserted = true
            }
        }

        return true
    }

    fun longestStrChain(words: Array<String>): Int {
        val sortedWords = words
            .distinct()
            .sortedBy { it.length }

        val indicesByLength = IntArray(1001) { -1 }
        sortedWords.forEachIndexed { index, word ->
            if (indicesByLength[word.length] == -1)
                indicesByLength[word.length] = index
        }

        val dp = IntArray(sortedWords.size)

        sortedWords.forEachIndexed { index, word ->
            dp[index] = 1

            if (indicesByLength[word.length - 1] == -1)
                return@forEachIndexed

            for (prevIndex in indicesByLength[word.length - 1] until index) {
                val prevWord = sortedWords[prevIndex]

                if (prevWord.length + 1 != word.length)
                    continue

                if (isChain(prevWord, word)) {
                    dp[index] = maxOf(dp[index], dp[prevIndex] + 1)
                }
            }
        }

        return dp.max()
    }
}