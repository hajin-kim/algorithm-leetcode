class Solution {
    fun myAtoi(s: String): Int {
        var i = s.indexOfFirst { it != ' ' }

        if (i == -1)
            return 0

        val sign: Int
        if (s[i] == '-') {
            sign = -1
            ++i
        } else if (s[i] == '+') {
            sign = 1
            ++i
        } else {
            sign = 1
        }

        var int = 0L
        while (i < s.length && s[i].isDigit()) {
            int *= 10
            int += s[i].digitToInt() * sign

            if (int > Int.MAX_VALUE)
                return Int.MAX_VALUE
            else if (int < Int.MIN_VALUE)
                return Int.MIN_VALUE

            ++i
        }

        return int.toInt()
    }
}
