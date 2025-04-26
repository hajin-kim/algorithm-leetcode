class Solution {
    fun countAndSay(n: Int): String {
        var result = "1"

        repeat(n - 1) {
            val newResult = StringBuilder()
            
            var count = 1
            var prev = result[0].digitToInt()

            for (i in 1 until result.length) {
                val num = result[i].digitToInt()
                if (num == prev) {
                    ++count
                }
                else {
                    newResult.append(count)
                    newResult.append(prev)

                    prev = num
                    count = 1
                }
            }
            newResult.append(count)
            newResult.append(prev)

            result = newResult.toString()
        }

        return result
    }
}