import kotlin.math.floor
import kotlin.math.ln
import kotlin.math.pow

class Solution {
    fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {
        val tests = minutesToTest / minutesToDie

        var pig = floor(ln(buckets.toDouble()) / ln(tests + 1.0))

        if (buckets > (tests + 1.0).pow(pig))
            pig++

        return pig.toInt()
    }
}