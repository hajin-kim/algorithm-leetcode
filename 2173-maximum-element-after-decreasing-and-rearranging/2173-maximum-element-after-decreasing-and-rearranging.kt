class Solution {
    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        arr.sort()

        var result = 0
        for (value in arr) {
            if (value > result) {
                ++result
            }
        }
        return result
    }
}