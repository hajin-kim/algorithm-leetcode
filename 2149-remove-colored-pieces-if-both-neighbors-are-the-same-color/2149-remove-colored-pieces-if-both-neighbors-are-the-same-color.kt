class Solution {
    fun winnerOfGame(colors: String): Boolean {
        val counts = IntArray('C'.code)
        val scores = IntArray('C'.code)

        for (color in colors) {
            ++counts[color.code]
            counts['B' - color + 'A'.code] = 0

            if (counts[color.code] >= 3)
                ++scores[color.code]
        }

        return scores['A'.code] > scores['B'.code]
    }
}