class Solution {
    fun findTheDifference(s: String, t: String): Char {
        val count = IntArray(26)

        s.forEach { count[it - 'a']++ }
        t.forEach {
            count[it - 'a']--
            if (count[it - 'a'] < 0)
                return it
        }
        
        return '-'
    }
}