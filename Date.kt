/**
 * Stores a date in the Gregorian calendar.
 * [(wikipedia)](https://pt.wikipedia.org/wiki/Calend%C3%A1rio_gregoriano)
 *
 * year: 1583..3000; month:1..12; day:1..31
 */
data class Date(val year:Int, val month:Int, val day:Int)

val bigMonths = listOf(1, 3, 5, 7, 8, 10, 12)
val smallMonths = listOf(4, 6, 9, 11)

/**
 *  Checks if the given date year is a leap year.
 *  @receiver The date year to check
 *  @return true if it's a leap year
 */
fun isLeapYear(year: Int): Boolean {
    if (year in 1980..2030 step 4 || year in 1600..3000 step 400) {
        return true
    }
    return false
}

/**
 *  Calculates the maximum number of days for a month, also checking if it's a leap year.
 *  @receiver The year and month of the date to check
 *  @return Maximum number of days for the given month
 */
fun maxDaysOfMonth(month: Int, year: Int): Int {
    val leapYear = isLeapYear(year)
    if (month in bigMonths) {
        return 31
    } else if (month in smallMonths) {
        return 30
    } else if (month == 2 && leapYear) {
        return 29
    } else if (month == 2 && !leapYear) {
        return 28
    }
    return 0
}

/**
 *  Checks whether the date is valid.
 *  @receiver The date to check
 *  @return true if the date is valid
 */
fun isValid(date: Date): Boolean {
    if (date.year in 1583..3000) {
        if (date.month in 1..12) {
            val max = maxDaysOfMonth(date.month, date.year)
            if (date.day in 1..max) {
                return true
            }
        }
    }
    return false
}

/**
 * Given a date, it returns the number of days since the beginning of the year for that date.
 * @receiver Date to use
 * @return Days since the beginning of the year
 */
fun toDayOfYear(date: Date): Int? {
    var numberOfDays = date.day
    val leapYear = isLeapYear(date.year)
    for (m in date.month - 1 downTo 1) {
        when (m in date.month - 1 downTo 1) {
            m in bigMonths -> numberOfDays += 31
            m in smallMonths -> numberOfDays += 30
            m == 2 && leapYear -> numberOfDays += 29
            m == 2 && !leapYear -> numberOfDays += 28
        }
        /*if (m in bigMonths) {
            numberOfDays += 31
        } else if (m in smallMonths) {
            numberOfDays += 30
        } else if (m == 2 && leapYear) {
            numberOfDays += 29
        } else if (m == 2 && !leapYear) {
            numberOfDays += 28
        }*/
    }
    return if (isValid(date)) numberOfDays else null
}

fun main() {
    println("Insert the year:")
    val year = Integer.valueOf(readLine())
    println("Insert the month:")
    val month = Integer.valueOf(readLine())
    println("Insert the day:")
    val day = Integer.valueOf(readLine())

    val chosenDate = Date(year, month, day)

    if (isValid(chosenDate)) {
        println("The date you've picked is valid.")
    } else {
        println("The date you've picked is not valid, please pick another.")
    }

    if (toDayOfYear(chosenDate) != null) {
        println("There has been " + toDayOfYear(chosenDate) + " days since the beginning of the year.")
    }
}