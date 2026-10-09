package org.example.lesson_11

// 1. Создайте пустой неизменяемый словарь,
// где ключами будут строки, а значениями -
// целые числа.

// 2. Создайте неизменяемый словарь,
// где ключами являются целые числа,
// а значениями - строки, и инициализируйте
// его несколькими парами.

// 3. Создайте изменяемый словарь, где ключами и значениями являются строки,
// и инициализируйте его несколькими парами.

// 4. Имея изменяемый словарь, добавьте в него новую пару ключ-значение.

// 5. Имея изменяемый словарь,
// удалите из него элемент по определенному ключу.

// 6. Создайте словарь и используйте цикл для
// вывода всех его ключей и соответствующих
// значений.


// 7. Напишите функцию для печати значения
// по заданному ключу с использованием цикла.
// Если значения нет -
// печатать "значение не найдено".

fun main() {
    val emptyMap: Map<String, Int> = emptyMap() // 1

    val constMap: Map<Int, String> = mapOf(
        1 to "Первый", 2 to "Второй") // 2

    val mutableMap: MutableMap<String, String> = mutableMapOf(
        "Птица" to "Голубь", "Копытное" to "Лама") // 3

    mutableMap["Кошачьи"] = "Гепард" // 4

    mutableMap.remove("Птица") // 5

    val cycleMap: Map<String, String> = mapOf(
        "Москва" to "Воронеж",
        "Хрен" to "Догонешь"
    )

    for ((key, value) in cycleMap) { // 6
        println("$key - $value")
    }

    val targetKey: Map <Int, String> = mapOf(
        1 to "Первый",
        2 to "Второй",
        3 to "Третий"
    )

    if (2 in targetKey) {
        println("Key 2: ${targetKey[2]}") // 7
    }
    else {
        println("Ничего не найдено")
    }

    val mapOne = mapOf(
        "String1" to 1,
        "String2" to 2
    )

    val mapTwo = mapOf(
        "String3" to 3,
        "String4" to 4
    )

    val mapThree: MutableMap<String, Int> = mutableMapOf()

    for ((key, value) in mapOne) {
        mapThree[key] = value
    }

    for ((key, value) in mapTwo) {
        if (key in mapThree) continue
        else mapThree[key] = value
        }
    }
    // Множество строк
    val SetMap = mapOf(
        setOf("mapOne") to 1,
        setOf("mapTwo") to 2)

}






