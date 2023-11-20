class Solution {
    fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
        val types = listOf('M', 'P', 'G')

        val travelingCost = types.sumOf { type ->
            val end = garbage.indexOfLast { it.contains(type) }
            if (end <= 0)
                0
            else
                travel.take(end).sum()
        }

        val collectionCost = garbage.sumOf { it.length }

        return travelingCost + collectionCost
    }
}