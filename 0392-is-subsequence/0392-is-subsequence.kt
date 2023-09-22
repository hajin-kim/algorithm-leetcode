class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty())
            return true
        
        var counter = 0
        t.forEach {
            if (it == s[counter]) {
                counter++
                if (counter == s.length)
                    return true
            }
        }
        return false
    }
}