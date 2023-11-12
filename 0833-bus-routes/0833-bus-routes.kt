class Solution {
    fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
        if (source == target)
            return 0

        val n = routes.size

        val busesByStop = mutableMapOf<Int, MutableList<Int>>()

        for (bus in routes.indices) {
            for (stop in routes[bus]) {
                busesByStop.getOrPut(stop) { mutableListOf() }.add(bus)
            }
        }

        val discovered = BooleanArray(n)
        var nTraveled = 0
        var travelingBuses: List<Int> = busesByStop[source] ?: return -1

        while (travelingBuses.isNotEmpty()) {
            ++nTraveled
            travelingBuses.forEach { discovered[it] = true }

            val stops = travelingBuses
                .flatMapTo(mutableSetOf()) { bus -> routes[bus].toList() }
            if (target in stops)
                return nTraveled
            travelingBuses = stops
                .flatMapTo(mutableSetOf()) { busesByStop[it] ?: emptyList() }
                .filter { bus -> !discovered[bus] }
        }

        return -1
    }
}