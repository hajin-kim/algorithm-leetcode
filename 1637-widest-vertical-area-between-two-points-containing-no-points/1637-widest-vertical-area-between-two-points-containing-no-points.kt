class Solution {
    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
        return points.map { it[0] }
            .sorted()
            .zipWithNext()
            .maxOf { (a, b) -> b - a }
    }
}