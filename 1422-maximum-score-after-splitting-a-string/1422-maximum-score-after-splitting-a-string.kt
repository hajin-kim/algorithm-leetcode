class Solution {
    fun maxScore(s: String): Int {
        var leftZeros = s.slice(0 until 1).count { it == '0' }
        var rightOnes = s.slice(1 until s.length).count { it == '1' }
        var maxScore = leftZeros + rightOnes

        for (i in 1 until s.length - 1) {
            val char = s[i]
            if (char == '0') {
                ++leftZeros
            } else {
                --rightOnes
            }

            val score = leftZeros + rightOnes
            maxScore = maxOf(maxScore, score)
        }
        
        return maxScore
    }
}