class Solution {
    private fun BooleanArray.clear() {
        for (i in indices) {
            this[i] = false
        }
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val isFilled = BooleanArray(10)

        for (row in board) {
            isFilled.clear()

            for (char in row) {
                if (char == '.') {
                    continue
                }

                val number = char.digitToInt()
                if (isFilled[number]) {
                    return false
                }
                isFilled[number] = true
            }
        }

        for (x in 0 until 9) {
            isFilled.clear()

            for (y in 0 until 9) {
                val char = board[y][x]

                if (char == '.') {
                    continue
                }

                val number = char.digitToInt()
                if (isFilled[number]) {
                    return false
                }
                isFilled[number] = true
            }
        }

        for (gridY in 0 until 3) {
            for (gridX in 0 until 3) {
                isFilled.clear()
                
                val startY = gridY * 3
                val startX = gridX * 3
                for (y in startY until startY + 3) {
                    for (x in startX until startX + 3) {
                        val char = board[y][x]

                        if (char == '.') {
                            continue
                        }

                        val number = char.digitToInt()
                        if (isFilled[number]) {
                            return false
                        }
                        isFilled[number] = true
                    }
                }
            }
        }
        
        return true
    }
}