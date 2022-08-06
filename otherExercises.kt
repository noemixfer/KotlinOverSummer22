import java.math.RoundingMode
import kotlin.math.roundToInt
import kotlin.math.sqrt

fun intersect(a: Int, b: Int, c: Int, d: Int): String {
    var min = 0
    var max = 0
    if (b < a || d < c) {
        return "Invalid ranges"
    } else if ((a < c && b < c) || (a > d && b > d)) {
        return "The ranges [$a, $b] and [$c, $d] do not intersect"
    } else {
        if (c in a..b) {
            min = c
        } else if (a in c..d) {
            min = a
        }
        if (b <= d) {
            max = b
        } else {
            max = d
        }
    }
    return "The intersection between the ranges [$a, $b] and [$c, $d] is [$min, $max]."
}

fun union(a: Int, b: Int, c: Int, d: Int): String {
    var min = 0
    var max = 0
    if (b < a || d < c) {
        return "Invalid ranges"
    } else if (a <= c) {
        min = a
    } else {
        min = c
    }
    if (b >= d) {
        max = b
    } else {
        max = d
    }
    return "The union between the ranges [$a, $b] and [$c, $d] is [$min, $max]."
}

fun unicode (a: Char) {
    val code = a.code
    println("Unicode of $a = $code.")
    if (code in 65..90) {
        println("Lowercased = ${(code + 32).toChar()}")
    } else if (code in 97..122) {
        println("Uppercased = ${(code - 32).toChar()}")
    }
}

fun coins(amount: Float) {
    var remaining = (amount * 100.0).roundToInt() / 100.0
    println("The total is $remaining. You may pay as follows:")
    val eur2 = remaining.toBigDecimal().setScale(0, RoundingMode.DOWN).toInt() / 2
    print("${eur2}x2Eur + ")
    remaining = (remaining - (eur2 * 2))
    val eur1 = remaining.toBigDecimal().setScale(0, RoundingMode.DOWN).toInt()
    remaining -= eur1
    print("${eur1}x1Eur + ")
    val cent50 = (remaining / 0.50).toInt()
    remaining -= (cent50 * 0.50)
    print("${cent50}x50c + ")
    val cent20 = (remaining / 0.20).toInt()
    remaining -= (cent20 * 0.20)
    print("${cent20}x20c + ")
    val cent10 = (remaining / 0.10).toInt()
    remaining -= (cent10 * 0.10)
    print("${cent10}x10c + ")
    val cent5 = (remaining / 0.05).toInt()
    remaining -= (cent5 * 0.05)
    print("${cent5}x5c + ")
    val cent2 = (remaining / 0.02).toInt()
    remaining -= (cent2 * 0.02)
    print("${cent2}x2c + ")
    val cent1 = (remaining*100).toInt()
    print("${cent1}x1c.")
}

fun quadratic(a: Double, b: Double, c: Double) {
    var x = b * b
    x -= 4 * a * c
    val sqrooted = sqrt(x)
    val x1 = (-1 * b - sqrooted)/(2 * a)
    val x2 = (-1 * b + sqrooted)/(2 * a)
    if (x < 0) {
        println("There's no solution")
    } else if (x1 == x2) {
        println("x = $x1")
    } else {
        println("x = $x1 or x = $x2")
    }
}

fun main() {
    println("First value of range A?")
    val a1 = Integer.valueOf(readLine())
    println("Second value of range A?")
    val a2 = Integer.valueOf(readLine())
    println("First value of range B?")
    val b1 = Integer.valueOf(readLine())
    println("Second value of range B?")
    val b2 = Integer.valueOf(readLine())

    println(intersect(a1, a2, b1, b2))
    println(union(a1, a2, b1, b2))

    println("\n-----------------------------------------\n")

    println("Enter a character:")
    val a = readLine()!!
    val char = a[0]
    unicode(char)

    println("\n-----------------------------------------\n")

    println("Enter the total:")
    val total = readLine()!!.toFloat()
    coins(total)

    println("\n-----------------------------------------\n")

    println("Let's solve some equations!")
    println("Enter the value of a:")
    val eqa = readLine()!!.toDouble()
    println("Enter the value of b:")
    val eqb = readLine()!!.toDouble()
    println("Enter the value of c:")
    val eqc = readLine()!!.toDouble()
    quadratic(eqa, eqb, eqc)

}