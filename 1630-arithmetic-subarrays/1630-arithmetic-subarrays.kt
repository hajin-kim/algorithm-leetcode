class Solution {
    private fun List<Int>.isArithmetic(): Boolean =
        this.asSequence()
            .sorted()
            .zipWithNext()
            .map { (prev, next) -> next - prev }
            .zipWithNext()
            .all { (prevDiff, nextDiff) -> prevDiff == nextDiff }


    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> =
        (l zip r).map { (left, right) ->
            nums
                .slice(left..right)
                .isArithmetic()
        }
}