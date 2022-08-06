fun multiple(num: Int): Boolean {
    print("$num é múltiplo de 3 == ")
    if (num % 3 == 0) {
        return true
    }
    return false
}

fun digits(num: Int): String {
    val numb = num.toString()
    val len = numb.length
    return "$num tem $len dígitos"
}

fun even(num: Int): Boolean {
    val numb = num.toString()
    val a = numb.first().digitToInt()
    val b = numb.last().digitToInt()
    print("$a e $b são pares == ")
    if (a % 2 == 0 && b % 2 == 0) {
        return true
    }
    return false
}

fun subtract(num: Int): Int {
    val numb = num.toString()
    val a = numb.first().digitToInt()
    val b = numb.last().digitToInt()
    print("$a - $b == ")
    return a - b
}

fun main() {
    println("Por favor insira um número inteiro positivo:")
    val num = Integer.valueOf(readLine())
    if (num <= 0) {
        println("O número que inseriu não é positivo.")
    } else {
        println(multiple(num))
        println(digits(num))
        println(even(num))
        println(subtract(num))
    }
}