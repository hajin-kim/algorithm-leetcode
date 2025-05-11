class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val target = target.toLong()

        nums.sort()

        val result = mutableListOf<List<Int>>()

        var prevA: Int? = null
        var prevB: Int? = null
        var prevC: Int? = null

        for (a in nums.indices) {
            if (nums[a] == prevA) {
                continue
            }

            for (b in (a + 1)..nums.lastIndex) {
                if (nums[a] == prevA && nums[b] == prevB) {
                    continue
                }

                for (c in (b + 1)..nums.lastIndex) {
                    if (nums[a] == prevA && nums[b] == prevB && nums[c] == prevC) {
                        continue
                    }

                    val sum3 = nums[a].toLong() + nums[b] + nums[c]
                    for (d in (c + 1)..nums.lastIndex) {
                        val sum4 = sum3 + nums[d]
                        if (sum4 > target) {
                            break
                        } else if (sum4 == target) {
                            result += listOf(nums[a], nums[b], nums[c], nums[d])
                            prevA = nums[a]
                            prevB = nums[b]
                            prevC = nums[c]
                            break
                        }
                    }
                }
            }
        }

        return result
    }
}
