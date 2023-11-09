class Solution {
    private val MODULO = 1000000007

    fun countHomogenous(s: String): Int = s
        .zipWithNext()
        .fold(1 to s.length) { (count, result), (prev, now) ->
            if (now == prev) {
                count + 1 to (result + count) % MODULO
            } else {
                1 to result
            }
        }
        .second
}