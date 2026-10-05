package org.example.lesson_09

fun main() {
    // Массивы
    arrayTask1()
    arrayTask2()
    arrayTask3()
    arrayTask4()
    arrayTask5()
    arrayTask6()
    arrayTask7()
    arrayTask8()
    arrayTask9()
    arrayTask10()
    // Списки
    listTask1()
    listTask2()
    listTask3()
    listTask4()
    listTask5()
    listTask6()
    listTask7()
    listTask8()
    listTask9()
    listTask10()
    listTask11()
    // Множества
    setTask1()
    setTask2()
    setTask3()
    setTask4()
    setTask5()
    setTask6()
    setTask7()
    setTask8()
}


// Массивы


// 1. Массив из 5 целых чисел от 1 до 5
fun arrayTask1() {
    val numbers = arrayOf(1, 2, 3, 4, 5)

    println("Array 1: ${numbers.contentToString()}")
}


// 2. Пустой массив строк размером 10 элементов
fun arrayTask2() {
    val strings = Array(10) { "" }

    println("Array 2: ${strings.contentToString()}")
}


// 3. Массив из 5 Double.
// Значение равно удвоенному индексу.
fun arrayTask3() {
    val numbers = Array(5) { index -> index * 2.0 }

    println("Array 3: ${numbers.contentToString()}")
}


// 4. Массив из 5 Int.
// Значение = индекс * 3.
fun arrayTask4() {
    val numbers = Array(5) { 0 }

    for (i in numbers.indices) {
        numbers[i] = i * 3
    }

    println("Array 4: ${numbers.contentToString()}")
}


// 5. Массив из 3 nullable String
fun arrayTask5() {
    val strings = arrayOf<String?>(null, "Hello", "Kotlin")

    println("Array 5: ${strings.contentToString()}")
}


// 6. Скопировать массив в новый массив через цикл
fun arrayTask6() {
    val numbers = arrayOf(1, 2, 3, 4, 5)
    val copy = Array(numbers.size) { 0 }

    for (i in numbers.indices) {
        copy[i] = numbers[i]
    }

    println("Array 6: ${copy.contentToString()}")
}


// 7. Вычесть один массив из другого
fun arrayTask7() {
    val first = arrayOf(10, 20, 30)
    val second = arrayOf(1, 2, 3)

    val result = Array(first.size) { 0 }

    for (i in first.indices) {
        result[i] = first[i] - second[i]
    }

    println("Array 7:")
    for (number in result) {
        println(number)
    }
}


// 8. Найти индекс числа 5 через while
fun arrayTask8() {
    val numbers = arrayOf(1, 3, 7, 5, 9)

    var i = 0
    var index = -1

    while (i < numbers.size) {
        if (numbers[i] == 5) {
            index = i
            break
        }

        i++
    }

    println("Array 8: index = $index")
}


// 9. Чётное или нечётное
fun arrayTask9() {
    val numbers = arrayOf(1, 2, 3, 4, 5)

    println("Array 9:")

    for (number in numbers) {
        if (number % 2 == 0) {
            println("$number — чётное")
        } else {
            println("$number — нечётное")
        }
    }
}


// 10. Поиск элемента, содержащего подстроку
fun arrayTask10() {
    val words = arrayOf("Kotlin", "Java", "Android")

    findString(words, "Kot")
}

fun findString(strings: Array<String>, search: String) {
    for (string in strings) {
        if (string.contains(search)) {
            println("Array 10: $string")
        }
    }
}


// Списки


// 1. Пустой неизменяемый список Int
fun listTask1() {
    val numbers = listOf<Int>()

    println("List 1: $numbers")
}


// 2. Неизменяемый список строк
fun listTask2() {
    val words = listOf("Hello", "World", "Kotlin")

    println("List 2: $words")
}


// 3. Изменяемый список от 1 до 5
fun listTask3() {
    val numbers = mutableListOf(1, 2, 3, 4, 5)

    println("List 3: $numbers")
}


// 4. Добавить 6, 7, 8
fun listTask4() {
    val numbers = mutableListOf(1, 2, 3, 4, 5)

    numbers.add(6)
    numbers.add(7)
    numbers.add(8)

    println("List 4: $numbers")
}


// 5. Удалить World
fun listTask5() {
    val words = mutableListOf("Hello", "World", "Kotlin")

    words.remove("World")

    println("List 5: $words")
}


// 6. Вывести каждый элемент через цикл
fun listTask6() {
    val numbers = listOf(1, 2, 3, 4, 5)

    println("List 6:")

    for (number in numbers) {
        println(number)
    }
}


// 7. Получить второй элемент
fun listTask7() {
    val words = listOf("Hello", "World", "Kotlin")

    println("List 7: ${words[1]}")
}


// 8. Изменить элемент с индексом 2
fun listTask8() {
    val numbers = mutableListOf(1, 2, 3, 4, 5)

    numbers[2] = 100

    println("List 8: $numbers")
}


// 9. Объединить два списка через циклы
fun listTask9() {
    val first = listOf("A", "B", "C")
    val second = listOf("D", "E", "F")

    val result = mutableListOf<String>()

    for (item in first) {
        result.add(item)
    }

    for (item in second) {
        result.add(item)
    }

    println("List 9: $result")
}


// 10. Найти минимум и максимум через цикл
fun listTask10() {
    val numbers = listOf(7, 2, 9, 1, 5)

    var min = numbers[0]
    var max = numbers[0]

    for (number in numbers) {
        if (number < min) {
            min = number
        }

        if (number > max) {
            max = number
        }
    }

    println("List 10: минимум = $min, максимум = $max")
}


// 11. Новый список только с чётными числами
fun listTask11() {
    val numbers = listOf(1, 2, 3, 4, 5, 6)

    val evenNumbers = mutableListOf<Int>()

    for (number in numbers) {
        if (number % 2 == 0) {
            evenNumbers.add(number)
        }
    }

    println("List 11: $evenNumbers")
}


// Множества


// 1. Пустое неизменяемое множество Int
fun setTask1() {
    val numbers = setOf<Int>()

    println("Set 1: $numbers")
}


// 2. Неизменяемое множество из 3 элементов
fun setTask2() {
    val numbers = setOf(1, 2, 3)

    println("Set 2: $numbers")
}


// 3. Изменяемое множество строк
fun setTask3() {
    val languages = mutableSetOf("Kotlin", "Java", "Scala")

    println("Set 3: $languages")
}


// 4. Добавить Swift и Go
fun setTask4() {
    val languages = mutableSetOf("Kotlin", "Java", "Scala")

    languages.add("Swift")
    languages.add("Go")

    println("Set 4: $languages")
}


// 5. Удалить элемент 2
fun setTask5() {
    val numbers = mutableSetOf(1, 2, 3, 4)

    numbers.remove(2)

    println("Set 5: $numbers")
}


// 6. Вывести элементы через цикл
fun setTask6() {
    val numbers = setOf(1, 2, 3, 4, 5)

    println("Set 6:")

    for (number in numbers) {
        println(number)
    }
}


// 7. Проверить наличие строки через цикл
fun setTask7() {
    val words = setOf("Kotlin", "Java", "Scala")

    val result = containsString(words, "Kotlin")

    println("Set 7: $result")
}

fun containsString(words: Set<String>, search: String): Boolean {
    for (word in words) {
        if (word == search) {
            return true
        }
    }

    return false
}


// 8. Конвертировать Set в MutableList через цикл
fun setTask8() {
    val words = setOf("Kotlin", "Java", "Scala")

    val list = mutableListOf<String>()

    for (word in words) {
        list.add(word)
    }

    println("Set 8: $list")
}