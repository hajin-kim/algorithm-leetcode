class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n: Int): Int {
        val bMask = 0b01_01_01_01_01_01_01_01_01_01_01_01_01_01_01_01
        val b0 = n ushr 0 and bMask
        val b1 = n ushr 1 and bMask
        val c = b0 + b1

        val dMask = 0b0011_0011_0011_0011_0011_0011_0011_0011
        val d0 = c ushr 0 and dMask
        val d2 = c ushr 2 and dMask
        val e = d0 + d2

        val fMask = 0b00001111_00001111_00001111_00001111
        val f0 = e ushr 0 and fMask
        val f4 = e ushr 4 and fMask
        val g = f0 + f4

        val hMask = 0b0000000011111111_0000000011111111
        val h0 = g ushr 0 and hMask
        val h8 = g ushr 8 and hMask
        val i = h0 + h8

        val jMask = 0b00000000000000001111111111111111
        val j0 = i ushr 0 and jMask
        val j16 = i ushr 16 and jMask
        return j0 + j16
    }
}