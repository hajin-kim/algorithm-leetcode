class Solution {
    private val even = setOf('0', '2', '4', '6', '8')

    fun largestOddNumber(num: String): String =
        num.dropLastWhile { it in even }
}