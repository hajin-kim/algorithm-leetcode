class SeatManager(n: Int) {
    private val heap = PriorityQueue<Int>()
        .apply { addAll(1..n) }

    fun reserve(): Int {
        return heap.poll()
    }

    fun unreserve(seatNumber: Int) {
        heap.add(seatNumber)
    }
}