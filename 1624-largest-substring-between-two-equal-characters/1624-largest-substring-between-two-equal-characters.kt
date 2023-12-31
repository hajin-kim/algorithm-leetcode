class Solution {
    fun maxLengthBetweenEqualCharacters(s: String): Int {
        val positionMap = hashMapOf<Char, Int>()

        var result = -1
        for (i in s.indices) {
            val char = s[i]

            if (char in positionMap) {
                val substringLength = i - positionMap[char]!! - 1
                result = maxOf(result, substringLength)
            } else
                positionMap[char] = i
        }

        return result
    }
}