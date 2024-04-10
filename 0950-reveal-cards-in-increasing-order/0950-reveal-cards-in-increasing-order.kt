class Solution {
    private val UNFILLED = 0

    fun deckRevealedIncreasing(deck: IntArray): IntArray {
        val n = deck.size
        deck.sort()

        val result = IntArray(n)

        var flip = true
        var iResult = 0
        var iDeck = 0

        while (iDeck < n) {
            if (result[iResult] == UNFILLED) {
                if (flip) {
                    result[iResult] = deck[iDeck]
                    iDeck++
                }
                flip = !flip
            }
            iResult = (iResult + 1) % n
        }

        return result
    }
}
