import java.util.LinkedList

class Solution {
    fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
        val iterators = LinkedList<Iterator<Int>>()
        val result = mutableListOf<Int>()

        var iNums = 0
        while (iNums < nums.size || iterators.isNotEmpty()) {
            if (iNums < nums.size) {
                val iterator = nums[iNums].iterator()
                iterators.addFirst(iterator)
                ++iNums
            }

            val iteratorsIterator = iterators.iterator()
            while (iteratorsIterator.hasNext()) {
                val iterator = iteratorsIterator.next()
                if (iterator.hasNext())
                    result.add(iterator.next())
                else
                    iteratorsIterator.remove()
            }
        }

        return result.toIntArray()
    }
}