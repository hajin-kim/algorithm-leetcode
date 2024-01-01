
class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sort()
        s.sort()
        
        var children = 0
        var i = 0
        while (i < s.size && children < g.size) {
            if (s[i] >= g[children]) {
                children++
            }
            i++
        }
        return children
    }
}