class Solution {
    fun findArray(pref: IntArray): IntArray {
        val arr = IntArray(pref.size)
        arr[0] = pref[0]

        for (i in 1 until pref.size) {
            arr[i] = pref[i - 1] xor pref[i]
        }

        return arr
    }
}