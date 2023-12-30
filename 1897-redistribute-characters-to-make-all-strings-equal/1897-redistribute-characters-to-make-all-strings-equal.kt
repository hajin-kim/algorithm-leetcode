class Solution {
    fun makeEqual(words: Array<String>): Boolean {
        val count = IntArray('z'.code + 1)

        for (word in words) {
            for (char in word)
                count[char.code]++
        }

        return count.all { it % words.size == 0 }
    }
}