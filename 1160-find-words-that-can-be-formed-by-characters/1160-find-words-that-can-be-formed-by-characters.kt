class Solution {
    private fun countOrZero(word: String, count: IntArray): Int {
        @Suppress("NAME_SHADOWING")
        val count = count.clone()

        for (char in word) {
            if (count[char.code] == 0)
                return 0
            --count[char.code]
        }
        return word.length
    }

    fun countCharacters(words: Array<String>, chars: String): Int {
        val count = IntArray('z'.code + 1)

        for (char in chars) {
            ++count[char.code]
        }

        return words.sumOf { countOrZero(it, count) }
    }
}