class Solution {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        return word1.flatMap { it.toList() } == word2.flatMap { it.toList() }
    }
}