class MyHashMap {
    private val hashSize = 32
    val hashTable = Array(hashSize) { mutableListOf<Pair<Int, Int>>() }

    private fun hash(key: Int): Int {
        return key % hashSize
    }

    fun put(key: Int, value: Int) {
        val hashes = hashTable[hash(key)]
        hashes.removeIf { it.first == key }
        hashes.add(key to value)
    }

    fun get(key: Int): Int {
        val found = hashTable[hash(key)].firstOrNull { it.first == key }
        return found?.second ?: -1
    }

    fun remove(key: Int) {
        hashTable[hash(key)].removeIf { it.first == key }
    }
}
