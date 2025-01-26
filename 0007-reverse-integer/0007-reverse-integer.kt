import kotlin.math.abs

class Solution {
    fun reverse(x: Int): Int {
        var origin = abs(x)
        var result = 0

        while (origin != 0) {
            var new = result * 10
            if (x < 0) {
                new -= origin % 10
            }
            else {
                new += origin % 10
            }

            if (new / 10 != result) {
                return 0
            }

            result = new
            origin /= 10
        }

        return result
    }
}
