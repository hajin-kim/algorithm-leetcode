class Solution {
    fun compareVersion(version1: String, version2: String): Int {
        var i1 = 0
        var i2 = 0

        var revision1: Int
        var revision2: Int

        while (true) {
            revision1 = 0
            while (i1 < version1.length && version1[i1] != '.') {
                revision1 *= 10
                revision1 += version1[i1].digitToInt()
                i1++
            }
            i1++

            revision2 = 0
            while (i2 < version2.length && version2[i2] != '.') {
                revision2 *= 10
                revision2 += version2[i2].digitToInt()
                i2++
            }
            i2++

            if (revision1 > revision2)
                return 1
            else if (revision1 < revision2)
                return -1
            else if (i1 >= version1.length && i2 >= version2.length)
                return 0
        }
    }
}
