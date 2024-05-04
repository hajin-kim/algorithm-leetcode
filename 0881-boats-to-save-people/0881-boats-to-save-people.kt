class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()

        var result = 0
        var light = 0
        var heavy = people.lastIndex

        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit)
                ++light
            --heavy
            ++result
        }
        
        return result
    }
}
