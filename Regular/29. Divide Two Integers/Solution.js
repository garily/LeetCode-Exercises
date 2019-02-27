/**
 * @param {number} dividend
 * @param {number} divisor
 * @return {number}
 */
const MAX_INT = 2147483647;
const MIN_INT = -2147483648;
var divide = (dividend, divisor) => {
    if (dividend == 0) return 0;
    if (dividend == MIN_INT && divisor == 1) return dividend;
    let sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
    
    let quotient = Math.floor(Math.exp(Math.log(Math.abs(dividend)) - Math.log(Math.abs(divisor))));
    if (quotient > MAX_INT || quotient < MIN_INT) return MAX_INT;
    return sign ? quotient : -quotient;
};
