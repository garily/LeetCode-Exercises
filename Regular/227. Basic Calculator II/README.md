[227. Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/)

## Explanation

Three `int` vairables are defined, a `waitNum` and two subsequent numbers, `num1` and `num2`.
The underlying principle is that for any expression in the form `a op1 b op2 c`, we can always deal with the second operand first, and depending on if it is addition/reduction or production/division, we update `a`, `b`, and `op1`
