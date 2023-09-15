class Solution {
    fun isPalindrome(x: Int): Boolean {
        val string = x.toString()
        return string == string.reversed()
    }
}
