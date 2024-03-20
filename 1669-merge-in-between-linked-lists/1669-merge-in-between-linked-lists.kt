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
    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode {
        var frontLast = list1!!
        repeat(a - 1) {
            frontLast = frontLast.next!!
        }

        var backFirst = frontLast
        repeat(b - a + 2) {
            backFirst = backFirst.next!!
        }

        var list2Last = list2!!
        while (list2Last.next != null)
            list2Last = list2Last.next!!

        frontLast.next = list2
        list2Last.next = backFirst

        return list1
    }
}
