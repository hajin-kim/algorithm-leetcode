class Solution {
    private fun List<Int>.isArithmetic(): Boolean {
        val min = min()
        val max = max()

        if (min == max)
            return true

        if ((max - min) % (size - 1) != 0)
            return false
        val step = (max - min) / (size - 1)

        val visited = BooleanArray(size + 1)

        for (num in this) {
            if ((num - min) % step != 0)
                return false
            val position = (num - min) / step

            if (visited[position])
                return false
            visited[position] = true
        }

        return true
    }

    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> =
        (l zip r).map { (left, right) ->
            nums
                .slice(left..right)
                .isArithmetic()
        }
}