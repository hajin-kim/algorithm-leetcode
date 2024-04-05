class Solution {
    fun makeGood(s: String): String {
        val result = arrayListOf<Char>()
        for (char in s) {
            var flag = true
            if (result.isNotEmpty()) {
                val last = result.last()
                if (last.isUpperCase() && char.isLowerCase() && last.lowercaseChar() == char ||
                    last.isLowerCase() && char.isUpperCase() && last == char.lowercaseChar()
                ) {
                    result.removeLast()
                    flag = false
                }
            }
            if (flag)
                result.add(char)
        }

        return result.joinToString("")
    }
}
