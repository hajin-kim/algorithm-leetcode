class Solution {
    fun decodeAtIndex(s: String, k: Int): String {
        val string = if (s.last().isLetter()) s + "2" else s

        val intervalSizes = mutableListOf(0L)
        val coefficients = mutableListOf(0L)
        val tokens = mutableListOf("")

        var isDigitBefore = false
        var nextB = 1L
        val accumulated = mutableListOf<Char>()
        for (char in string) {
            if (char.isDigit() != isDigitBefore) {
                if (!isDigitBefore) {
                    tokens.add(accumulated.joinToString(""))
                    coefficients.add(nextB)
                    intervalSizes.add(intervalSizes.last() * nextB + accumulated.size)
                } else {
                    nextB = accumulated.fold(1L) { acc: Long, c: Char -> acc * c.digitToInt() }
                }

                isDigitBefore = !isDigitBefore
                accumulated.clear()
            }

            accumulated.add(char)
        }

        var remainder = k - 1L
        var current = intervalSizes.size - 1
        while (current > 0) {
            remainder %= intervalSizes[current]
            val additionalPartStartsAt = intervalSizes[current - 1] * coefficients[current]
            if (remainder >= additionalPartStartsAt) {
                return tokens[current][(remainder - additionalPartStartsAt).toInt()].toString()
            }
            --current
        }

        return ""
    }
}