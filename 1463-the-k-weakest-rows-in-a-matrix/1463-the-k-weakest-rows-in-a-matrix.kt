import java.util.*

class Solution {

    private fun IntArray.binarySearchDescending(target: Int): Int {
        var left = 0
        var right = size - 1

        while (left <= right) {
            val mid = (left + right) / 2
            if (this[mid] == target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return left
    }

    private val lsb32bitMask = ((1UL shl 32) - 1UL)
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val n = mat[0].size

        val x = mat
            .mapIndexed { index, it ->
                val soldiers = it.binarySearchDescending(0)
                (soldiers.toULong() shl 32) and (lsb32bitMask.inv()) or index.toULong()
            }
            .toMutableList()

        val y = PriorityQueue(x)

        return IntArray(k) { (y.poll() and lsb32bitMask).toInt() }
    }
}