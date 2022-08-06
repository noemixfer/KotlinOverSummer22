/**
 * This function calculates the average of the best n numbers in the list it's applied to.
 * @receiver The amount (n) of numbers to consider for the calculation
 * @return The average of the best n numbers
 */
fun List<Int>.averageOfBest(n:Int):Float {
    if (n >= 0 && this.size >= 0) {
        var list: List<Int> = emptyList()
        val originalList = this.sorted().reversed()
        for (i in 0 until n) {
            list += originalList[i]
        }
        return list.average().toFloat()
    }
    return 0F
}

/**
 * This function turns a list into a string with no space characters.
 * @return A string with the list of numbers with no spaces in between
 */
fun List<Int>.toText() :String {
    var string: String = ""
    for (i in 0 until this.size - 1) {
        string += "${this[i]},"
    }
    string += "${this[this.size - 1]}"
    return string
}

data class Student(val number:Int, val name:String, val evalForms:List<Int>)

/**
 * This function makes up a string based on the information contained in the Student type variable it's applied to
 * @return A string with details on the variable, such as number, name, grades and average of the best 3 grades.
 */
fun Student.toText(): String {
    return "$number - $name, fichas = ${evalForms.toText()} -> ${evalForms.averageOfBest(3)}."
}

fun main() {
    val firstStudent = Student(7777, "Jane Doe", listOf(12, 17, 4, 8))
    println(firstStudent.toText())
}


