class Solution {
    fun lengthOfLastWord(s: String): Int {
        var end = s.lastIndex
        while (s[end] == ' ') --end

        var start = end
        while (start >= 0 && s[start] != ' ') --start
        
        return end - start
    }
}
