/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     fun guess(word: String): Int {}
 * }
 */
class Solution {
    private fun String.partialMatches(other: String): Int {
        return foldIndexed(0) { j, acc, char -> acc + (if (char == other[j]) 1 else 0) }
    }

    fun findSecretWord(words: Array<String>, master: Master) {
        words.sortBy { it.toCharArray().distinct().size }

        val isRemoved = mutableSetOf<String>()

        for (word in words) {
            if (word in isRemoved) {
                continue
            }

            val guessed = master.guess(word)
            if (guessed == 6) {
                return
            }

            isRemoved += words.filter {
                it !in isRemoved && it.partialMatches(word) != guessed
            }
        }
    }
}
