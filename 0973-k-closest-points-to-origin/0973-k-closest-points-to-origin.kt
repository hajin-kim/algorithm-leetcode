class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        return points
            .sortedBy { (x, y) -> x * x + y * y }
            .take(k)
            .toTypedArray()
    }
}
