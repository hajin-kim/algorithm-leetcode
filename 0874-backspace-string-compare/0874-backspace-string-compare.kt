class Solution {
    private fun String.moveByBackspace(beginExclusive: Int): Int {
        var nBackspaces = 0
        var i = beginExclusive - 1
        while (i >= 0 && (this[i] == '#' || nBackspaces > 0)) {
            if (this[i] == '#')
                ++nBackspaces
            else
                --nBackspaces
            --i
        }
        return i
    }


    fun backspaceCompare(s: String, t: String): Boolean {
        var sIndex = s.moveByBackspace(s.length)
        var tIndex = t.moveByBackspace(t.length)
        while (sIndex >= 0 && tIndex >= 0) {
            if (s[sIndex] != t[tIndex])
                return false
            sIndex = s.moveByBackspace(sIndex)
            tIndex = t.moveByBackspace(tIndex)
        }
        return sIndex == tIndex // all zero
    }
}