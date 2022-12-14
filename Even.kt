/**
 * Checks whether a number is even.
 * A number is even if the remainder of the division by two is zero.
 * @param n Number to classify about parity
 * @return true if n is even or false if n is odd.
 */
fun isEven(n :Int) :Boolean {
    if (n % 2 == 0) {
        return true
    }
    return false
}

