/**
 * Returns the number of equal sides of a triangle (0, 2 or 3)
 * or -1 if it is not possible to form a triangle.
 * @param side1 length of first side
 * @param side2 length of second side
 * @param side1 length of third side
 * @return Number of equals sides (0,2,3) or null if is invalid
 */
fun equalSidesOfTriangle(side1 :Int, side2 :Int, side3 :Int): Int? {
    if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
        return null
    } else {
        if (side1 == side2 && side2 == side3) {
            return 3
        } else if (side1 != side2 && side1 != side3 && side2 != side3) {
            return 0
        }
    }
    return 2
}