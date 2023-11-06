class SeatManager(n: Int) {
    private val redBlackTree = sortedSetOf<Int>()
        .apply { addAll(1..n) }

    fun reserve(): Int {
        return redBlackTree.pollFirst()!!
    }

    fun unreserve(seatNumber: Int) {
        redBlackTree.add(seatNumber)
    }
}