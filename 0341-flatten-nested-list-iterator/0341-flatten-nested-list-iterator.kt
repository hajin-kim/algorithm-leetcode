class NestedIterator(nestedList: List<NestedInteger>) {
    private val flat: List<Int> = nestedList.flatten()
    private val iterator = flat.iterator()

    private fun List<NestedInteger>.flatten(): List<Int> =
        flatMap {
            if (it.isInteger())
                listOf(it.getInteger()!!)
            else
                it.getList()!!.flatten()
        }

    fun next(): Int {
        return iterator.next()
    }

    fun hasNext(): Boolean {
        return iterator.hasNext()
    }
}
