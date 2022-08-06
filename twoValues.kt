fun compare(num1: Int, num2: Int): Boolean {
    print("$num1 < $num2 == ")
    if (num1 < num2) {
        return true
    }
    return false
}

fun add(num1: Int, num2: Int): Int {
    print("$num1 + $num2 == ")
    return num1 + num2
}

fun subtract(num1: Int, num2: Int): Int {
    print("$num1 - $num2 == ")
    return num1 - num2
}

fun multiply(num1: Int, num2: Int): Int {
    print("$num1 * $num2 == ")
    return num1 * num2
}

fun divide(num1: Int, num2: Int): Double {
    print("$num1 / $num2 == ")
    return num1.toDouble() / num2.toDouble()
}

fun main() {
    println("Enter number A:")
    val a = Integer.valueOf(readLine())
    println("Enter number B:")
    val b = Integer.valueOf(readLine())

    println(compare(a, b))
    println(add(a, b))
    println(subtract(a, b))
    println(multiply(a, b))
    println(divide(a, b))
}