class Solution {
    private val VOWELS = setOf(
        'a', 'e', 'i', 'o', 'u',
        'A', 'E', 'I', 'O', 'U',
    )

    fun sortVowels(s: String): String {
        val vowelsIterator = s
            .filter { it in VOWELS }
            .toCharArray()
            .apply { sort() }
            .iterator()

        return buildString {
            for (char in s) {
                val toAdd =
                    if (char in VOWELS)
                        vowelsIterator.next()
                    else
                        char

                append(toAdd)
            }
        }
    }
}