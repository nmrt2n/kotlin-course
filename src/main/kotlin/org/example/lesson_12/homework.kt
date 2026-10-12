package org.example.lesson_12

// 1. Не принимает аргументов и не возвращает значения.
fun getVoid(){
}

//2. Принимает два целых числа и возвращает их сумму.
fun getSumInt(a: Int, b: Int): Int = a + b

//3. Принимает строку и ничего не возвращает.
fun getVoidString(line: String) {

}

//4. Принимает список целых чисел и возвращает среднее значение типа Double.
fun getAvenger(line: List<Int>): Double {
    val n = line.size
    var sumLine = 0
    for (num in line) {
        sumLine += num
    }
    return sumLine.toDouble() / n
}
//5. Принимает nullable строку и возвращает её длину в виде nullable целого числа и доступна только в текущем файле.
private fun getLength(line: String?): Int? {
    return line?.lenght
}

//6. Не принимает аргументов и возвращает nullable вещественное число.
fun getNumber(): Double {
    return null
}
//7. Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.
private fun getNullableList(line: List<Int>?) {
}

//8. Принимает целое число и возвращает nullable строку.
fun getIntNumber(num: Int): String? {
    return null
}

//9. Не принимает аргументов и возвращает список nullable строк.
fun getNullableVoid(): List<String?> {
    return listOf(null)
}

//10. Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
fun getNullableBoolean(line: String?, num: Int?): Boolean? {
    return null
}


//11. Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.

fun multiplyByTwo(num: Int): Int {
    return num * 2
}

//12. Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное, и false в противном случае.

fun isEven(num: Int): Boolean { // fun isEven(num: Int) = num % 2 == 0
    return num % 2 == 0
}

// 13. Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n. Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.

fun printNumbersUntil(n: Int) {
    if (n < 1) {
        return
    }

    var number = 1

    while (number <= n) {
        println(number)
        number += 1
    }
}

// 14. Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое отрицательное число в списке. Если отрицательных чисел нет, функция должна вернуть null.

fun findFirstNegative(numbers: List<Int>): Int? {
    for (num in numbers) {
        if (num < 0) {
            return num
        }
    }

    return null
}

// 15. Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и выводить каждую строку. Если встречается null значение, функция должна прекратить выполнение с помощью return без возврата значения.
fun processList(lines: List<String?>) {
    for (line in lines) {
        if (line == null) {
            return
        }

        println(line)
    }
}