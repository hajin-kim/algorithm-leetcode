import java.util.Stack

class Solution {
    private val OPERATORS = arrayOf(
        "+", "-", "*", "/"
    )

    fun evalRPN(tokens: Array<String>): Int {
        val numbers = Stack<Int>()

        for (token in tokens) {
            if (token !in OPERATORS) {
                numbers.push(token.toInt())
            } else {
                val op2 = numbers.pop()
                val op1 = numbers.pop()

                val result = when (token) {
                    "+" -> op1 + op2
                    "-" -> op1 - op2
                    "*" -> op1 * op2
                    else -> op1 / op2
                }

                numbers.push(result)
            }
        }

        return numbers.pop()
    }
}
