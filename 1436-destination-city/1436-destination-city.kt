class Solution {
    fun destCity(paths: List<List<String>>): String {
        val set = paths.map { it[0] }.toSet()

        return paths.map { it[1] }.first { it !in set }
    }
}