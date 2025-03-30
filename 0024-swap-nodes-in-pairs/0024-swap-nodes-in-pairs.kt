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
    fun swapPairs(head: ListNode?): ListNode? {
        val ret = head?.next
        ret ?: return head

        var prev: ListNode? = null
        var odd: ListNode? = null
        var now = head
        while (now != null) {
            if (odd == null) {
                odd = now

                now = now.next
            } else {
                prev?.next = now
                odd.next = now.next
                now.next = odd

                now = odd.next

                prev = odd
                odd = null
            }
        }

        return ret
    }
}
