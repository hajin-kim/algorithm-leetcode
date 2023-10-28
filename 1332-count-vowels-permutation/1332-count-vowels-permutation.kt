class Solution {
    private val a = 0
    private val e = 1
    private val i = 2
    private val o = 3
    private val u = 4

    private val MOD = 1000000007

    fun countVowelPermutation(n: Int): Int {
        val vowels = LongArray(5) { 1 }
        val temp = LongArray(5)

        repeat(n - 1) {
            temp[a] = (vowels[e] + vowels[i] + vowels[u]) % MOD
            temp[e] = (vowels[a] + vowels[i]) % MOD
            temp[i] = (vowels[e] + vowels[o]) % MOD
            temp[o] = (vowels[i]) % MOD
            temp[u] = (vowels[i] + vowels[o]) % MOD
            temp.copyInto(vowels)
        }

        return (vowels.sum() % MOD).toInt()
    }
}