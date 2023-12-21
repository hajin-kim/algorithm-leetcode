class Solution {
    private val NOT_FOUND = -1

    fun numSpecial(mat: Array<IntArray>): Int {
        val counts = IntArray(mat[0].size)

        for (row in mat) {
            var found = NOT_FOUND

            for (i in row.indices) {
                if (row[i] == 1) {
                    if (found == NOT_FOUND) {
                        found = i
                        counts[found] += 1
                    } else {
                        counts[found] += 2
                        counts[i] += 2
                    }
                }
            }
        }

        return counts.count { it == 1 }
    }
}