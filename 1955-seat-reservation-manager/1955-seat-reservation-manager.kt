class SeatManager(n: Int) {
    private val set = sortedSetOf(
        *(Array(n) { it + 1 })
    )

    fun reserve(): Int {
        return set.pollFirst()!!
    }

    fun unreserve(seatNumber: Int) {
        set.add(seatNumber)
    }
}