class Solution {
    fun getWinner(arr: IntArray, k: Int): Int {
        if (k >= arr.size - 1)
            return arr.max()

        fun Int.shift(): Int = (this + 1) % arr.size

        var iWinner = 0
        var winCount = 0
        var iCounter = 1

        while (winCount < k) {
            if (arr[iWinner] > arr[iCounter]) {
                iCounter = iCounter.shift()
                winCount++
            } else {
                iWinner = iCounter
                iCounter = iWinner.shift()
                winCount = 1
            }
        }

        return arr[iWinner]
    }
}