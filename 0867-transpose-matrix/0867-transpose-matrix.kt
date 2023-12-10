class Solution {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> =
        Array(matrix[0].size) { r -> IntArray(matrix.size) { c -> matrix[c][r] } }
}