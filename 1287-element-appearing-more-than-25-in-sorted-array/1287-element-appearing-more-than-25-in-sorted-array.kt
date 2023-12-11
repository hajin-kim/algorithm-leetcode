class Solution {
    fun findSpecialInteger(arr: IntArray): Int {
        val quarter = arr.size / 4

        for (i in 0 until arr.size - quarter) {
            if (arr[i] == arr[i + quarter])
                return arr[i]
        }

        return -1
    }
}