class Solution {
    private val REPEAT = 3

    fun largestGoodInteger(num: String): String {
        var count = 0
        var result = '-'
        var target = '-'

        for (char in num) {
            if (char == target) {
                ++count
                if (count == REPEAT) {
                    result = maxOf(result, target)
                }
            } else {
                target = char
                count = 1
            }
        }

        return if (result == '-') "" else result.toString().repeat(REPEAT)
    }
}