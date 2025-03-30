class LinkedNode(
    val key: Int,
    var value: Int,
    var prev: LinkedNode?,
    var next: LinkedNode?,
)

class LRUCache(private val capacity: Int) {
    private val pointerByKey = hashMapOf<Int, LinkedNode>()
    private var lruKey: LinkedNode? = null // head
    private var mruKey: LinkedNode? = null // tail
    private var size = 0

    fun get(key: Int): Int {
        val node = pointerByKey[key]
        node ?: return -1

        val value = node.value

        // pointer comparison
        if (node !== mruKey) {
            node.prev?.next = node.next
            node.next?.prev = node.prev
            if (node === lruKey) {
                lruKey = node.next
            }

            mruKey!!.next = node
            node.prev = mruKey
            node.next = null
            mruKey = node
        }

        return value
    }

    fun put(key: Int, value: Int) {
        val cached = get(key)
        if (cached != -1) {
            mruKey!!.value = value
            return
        }

        if (size == capacity) {
            val removed = lruKey!!
            val newLruKey = removed.next

            pointerByKey.remove(removed.key)

            removed.next = null
            newLruKey?.prev = null

            lruKey = newLruKey
        } else {
            ++size
        }

        val newNode = LinkedNode(
            key = key,
            value = value,
            prev = mruKey,
            next = null,
        )
        pointerByKey[key] = newNode

        if (lruKey == null) {
            lruKey = newNode
        }

        mruKey?.next = newNode
        mruKey = newNode
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
