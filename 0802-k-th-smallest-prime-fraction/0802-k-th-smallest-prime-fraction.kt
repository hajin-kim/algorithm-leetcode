class Solution {
    fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
        val sortedSet = sortedSetOf<Pair<Int, Int>>(comparator = { (a1, a2), (b1, b2) ->
            compareValues(arr[a1] * arr[b2], arr[a2] * arr[b1])
        })
        sortedSet += 0 to arr.lastIndex

        repeat(k - 1) {
            val (left, right) = sortedSet.pollFirst()!!
            if (left < right) {
                if (left < arr.lastIndex)
                    sortedSet += left + 1 to right
                if (right > 0)
                    sortedSet += left to right - 1
            }
        }

        val (left, right) = sortedSet.pollFirst()!!
        return intArrayOf(arr[left], arr[right])
    }
}
