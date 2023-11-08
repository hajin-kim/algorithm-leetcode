import kotlin.math.abs

class Solution {
    fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean {
        val distance = maxOf(abs(fx - sx), abs(fy - sy))
        return if (distance == 0) t != 1 else distance <= t
    }
}