class Solution {
    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int = dist
        .zip(speed)
        .map { (dist, speed) -> (dist - 1) / speed }
        .sorted()
        .withIndex()
        .takeWhile { (index, time) -> time >= index }
        .size
}