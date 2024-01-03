class Solution {
    fun String.countOne(): Int = this.count { it == '1' }

    fun numberOfBeams(bank: Array<String>): Int {
        var result = 0
        var prev = bank[0].countOne()

        for (i in 1 until bank.size) {
            val now = bank[i].countOne()
            
            if (now == 0)
                continue
            
            result += prev * now
            prev = now
        }
        
        return result
    }
}