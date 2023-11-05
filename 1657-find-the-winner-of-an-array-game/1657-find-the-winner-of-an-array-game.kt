class Solution {
    fun getWinner(arr: IntArray, k: Int): Int {
        var winner = arr[0]
        var winCount = 0
        var i = 1

        while (winCount < k && i < arr.size) {
            if (winner > arr[i]) {
                winCount++
            } else {
                winner = arr[i]
                winCount = 1
            }
            ++i
        }

        return winner // winner found in single iteration or arr.max()
    }
}