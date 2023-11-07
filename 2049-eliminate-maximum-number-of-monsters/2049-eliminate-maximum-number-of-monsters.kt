class Solution {
    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
        return dist
            .zip(speed)
            .map { (it.first - 1) / it.second }
            .sorted()
            .withIndex()
            .takeWhile { (index, time) -> time >= index }
            .size
    }
}