class Solution {

    fun getRow(rowIndex: Int): List<Int> {
        var prev = IntArray(rowIndex + 3)
        prev[0] = 0
        prev[1] = 1
        prev[2] = 0
        var next = IntArray(rowIndex + 3)

        for (i in 0 until rowIndex) {
            for (j in 1..i + 2)
                next[j] = prev[j - 1] + prev[j]

            val temp = prev
            prev = next
            next = temp
        }

        return prev.slice(1 until rowIndex + 2)
    }
}