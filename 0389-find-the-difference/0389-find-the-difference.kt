class Solution {
    fun findTheDifference(s: String, t: String): Char {
        val count = IntArray(26)

        for (it in s) {
            count[it - 'a']++
        }
        for (it in t) {
            count[it - 'a']--
            if (count[it - 'a'] < 0)
                return it
        }

        return '-'
    }
}