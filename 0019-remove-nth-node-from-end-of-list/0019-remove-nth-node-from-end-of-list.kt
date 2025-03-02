/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    private fun remove(head: ListNode?, n: Int, i: Int): Pair<ListNode?, Int> {
        if (head == null) {
            return null to i
        }
        val (next, lastIndex) = remove(head.next, n, i + 1)

        if (lastIndex - i == n) {
            return next to lastIndex
        }
        head.next = next
        return head to lastIndex
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) {
            return null
        }
        val (next, lastIndex) = remove(head, n, 0)
        if (lastIndex == n) {
            return next
        }
        return head
    }
}
