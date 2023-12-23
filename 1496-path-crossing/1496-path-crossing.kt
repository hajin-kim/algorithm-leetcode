class Solution {
    fun isPathCrossing(path: String): Boolean {
        var now = 0 to 0
        val visitedPoints = mutableSetOf(now)

        for (direction in path) {
            now = now.let { (x, y) ->
                when (direction) {
                    'N' -> x to y + 1
                    'S' -> x to y - 1
                    'E' -> x + 1 to y
                    'W' -> x - 1 to y
                    else -> throw IllegalArgumentException()
                }
            }

            if (now in visitedPoints)
                return true
            
            visitedPoints.add(now)
        }

        return false
    }
}