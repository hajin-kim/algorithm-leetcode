class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val map = hashMapOf<Char, Char>()
        val set = hashSetOf<Char>()
        for ((before, after) in s zip t) {
            if (before !in map) {
                if (after in set)
                    return false
                map[before] = after
                set += after
            } else if (map[before] != after)
                return false
        }
        return true
    }
}
