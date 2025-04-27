class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var first = 0
        var second = numbers.lastIndex
        
        var sum = numbers[first] + numbers[second]

        while (sum != target) {
            if (sum < target) {
                ++first
            }
            else {
                --second
            }
            sum = numbers[first] + numbers[second]
        }

        return intArrayOf(first + 1, second + 1)
    }
}