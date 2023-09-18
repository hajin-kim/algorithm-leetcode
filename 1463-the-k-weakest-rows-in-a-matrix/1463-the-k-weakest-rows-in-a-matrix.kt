class Solution {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val n = mat[0].size

        return mat
            .map {
                val soldiers = it.indexOf(0)
                if (soldiers == -1) n else soldiers
            }
            .withIndex()
            .sortedBy { it.value }
            .take(k)
            .map { it.index }
            .toIntArray()
    }
}