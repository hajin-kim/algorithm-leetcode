class Solution {
    fun isPowerOfFour(n: Int): Boolean = n.countOneBits() == 1 &&
            n.countTrailingZeroBits() % 2 == 0
}