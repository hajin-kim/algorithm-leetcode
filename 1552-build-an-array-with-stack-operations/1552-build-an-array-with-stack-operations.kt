class Solution {
    fun buildArray(target: IntArray, n: Int): List<String> {
        val result = mutableListOf<String>()
        var streamPeak = 0

        for (number in target) {
            repeat(number - streamPeak - 1) {
                result.add("Push")
                result.add("Pop")
            }
            result.add("Push")
            streamPeak = number
        }

        return result
    }
}