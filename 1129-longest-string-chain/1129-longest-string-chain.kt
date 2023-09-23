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
        val wordMap = words
            .distinct()
            .groupBy { it.length }
            .toSortedMap()
            .mapValues { (_, v) -> v.toTypedArray() }

        val dp = mutableMapOf<String, Int>()

        wordMap.keys.forEach {
            wordMap[it]!!.forEach { word ->
                dp[word] = 1

                wordMap[it - 1]?.forEach { prevWord ->
                    if (isChain(prevWord, word)) {
                        dp[word] = maxOf(dp[word]!!, dp[prevWord]!! + 1)
                    }
                }
            }
        }

        return dp.values.max()
    }
}