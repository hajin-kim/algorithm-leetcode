class Solution {
    fun minOperations(s: String): Int {
        var even = 0
        var odd = 0

        for (i in s.indices) {
            val char = s[i]
            if ((char == '0') == (i % 2 == 0))
                ++even
            else
                ++odd
        }

        return minOf(even, odd)
    }
}