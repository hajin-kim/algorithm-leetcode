class Solution {
    private val cache = mutableMapOf<Pair<Int, Int>, Pair<Int, Int>>()
    private fun assertOneAndTrailingZeros(n: Int, digit: Int): Pair<Int, Int> {
        if (digit == -1)
            return n to 0

        if (n.countTrailingZeroBits() == digit)
            return n to 0

        val mask = 1 shl digit

        val key = n % (mask shl 1) to digit
        if (key in cache) {
            val (new, operations) = cache[key]!!
            return ((n ushr (digit + 1) shl (digit + 1)) + (new % (mask shl 1))) to operations
        }

        @Suppress("NAME_SHADOWING")
        var n = n
        var operations = 0

        if (n and mask == 0) {
            val (new, newOperations) = assertOneAndTrailingZeros(n, digit - 1)
            n = new
            operations += newOperations

            // set `digit` bit
            n = n xor mask
            operations++
        }

        val (new, newOperations) = assertZeros(n, digit - 1)
        n = new
        operations += newOperations

        val result = n to operations
        cache[key] = result

        return result
    }

    private fun assertZeros(n: Int, digit: Int): Pair<Int, Int> {
        if (digit == -1)
            return n to 0

        val mask = 1 shl digit

        @Suppress("NAME_SHADOWING")
        var n = n
        var operations = 0

        if (n and mask != 0) {
            val (new, newOperations) = assertOneAndTrailingZeros(n, digit - 1)
            n = new
            operations += newOperations

            // unset `digit` bit
            n = n xor mask
            operations++
        }

        val (new, newOperations) = assertZeros(n, digit - 1)
        n = new
        operations += newOperations

        return n to operations
    }

    fun minimumOneBitOperations(n: Int): Int {
        return assertZeros(n, 30).second
    }
}