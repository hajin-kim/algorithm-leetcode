class Solution {

    fun getRow(rowIndex: Int): List<Int> =
        (1L..rowIndex).scan(1) { prev: Int, k: Long ->
            (prev * (rowIndex - k + 1) / k).toInt()
        }
}