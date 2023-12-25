class Solution {
    fun numDecodings(s: String): Int {
        if (s[0] == '0')
            return 0

        val cache = IntArray(s.length + 1)
        cache[0] = 1
        cache[1] = 1

        for (i in 1 until s.length) {
            val tens = s.slice(i - 1..i)

            if (tens in setOf("10", "20"))
                cache[i + 1] = cache[i - 1]
            else if (tens in "10".."26") {
                cache[i + 1] = cache[i] + cache[i - 1]
            } else if (s[i] == '0')
                return 0
            else
                cache[i + 1] = cache[i]
        }

        return cache.last()
    }
}