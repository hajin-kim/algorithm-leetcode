class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val distances = points
            .map { (x, y) ->
                x * x + y * y
            }

        return points
            .withIndex()
            .sortedBy { (index, _) -> distances[index] }
            .take(k)
            .map { it.value }
            .toTypedArray()
    }
}
