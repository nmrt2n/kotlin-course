package org.example.lesson_11

val firstMap: Map<Int, Int> = emptyMap() // 1.Создайте пустой неизменяемый словарь,где ключи и значения - целые числа.

val secondMap: Map<Float, Double> = mapOf( //  2.Создайте словарь, инициализированный несколькими парами "ключ-значение", где ключи - float, а значения - double
    1.2f to 2.20,
    1.3f to 3.30)

val thirdMap: MutableMap<Int, String> = mutableMapOf( // 3.Создайте изменяемый словарь, где ключи - целые числа, а значения - строки.
    1 to "first",
    2 to "second")

val fourthMap: Map<Double, Int> = mapOf( // 7.Создайте словарь (ключи Double, значения Int)
    2.20 to 2,
    3.30 to 3)

val first: Map<String, String> = mapOf( // 9.Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
    "Map 1 String 1" to "String 1 Map 1",
    "Map 1 String 2" to "String 2"
)

val second: Map<String, String> = mapOf( // 9.Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
    "Map 2 String 1" to "String 1 Map 2",
    "Map 2 String 2" to "String 2 Map 2"
)

val third: MutableMap<String, String> = mutableMapOf() // 9.Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.


val stringListMap = mutableMapOf( // 10.Создайте словарь, где ключами являются строки, а значениями - списки целых чисел.
    "String 1" to listOf(1, 2, 3),
    "String 2" to listOf(4, 5, 6)
)

val intSetMap = mutableMapOf( // 11. Создай словарь, в котором ключи - это целые числа, а значения - изменяемые множества строк.
    1 to mutableSetOf(
        "Первая строка",
        "Вторая строка"
    ),
    2 to mutableSetOf(
        "Третья строка",
        "Четвёртая строка"
    )
)

val pairMap = mutableMapOf( // 12. Создай словарь, где ключами будут пары чисел.
    Pair(1, 2) to "Первая пара",
    Pair(3, 5) to "Вторая пара",
    Pair(5, 7) to "Третья пара",
    Pair(8, 9) to "Четвёртая пара"
)

fun main(){
    thirdMap[2] = "third" // 4. Добавить в изменяемый словарь новую пару значений
    println(thirdMap[1]) // 5. Извлеките значение, используя ключ.
    println(thirdMap[4]) // 5. Попробуй получить значение с ключом, которого в словаре нет.
    thirdMap.remove(key = 1) // 6. Удалите определенный элемент из изменяемого словаря по его ключу.

    for ((key, value) in fourthMap) { // 7. Выведи в цикле результат деления ключа на значение. Не забудь обработать деление на 0 (в этом случае выведи слово “бесконечность”)
        if (value == 0) {
            println("Бесконечно")
        } else {
            println(key/value)
        }
    }

    thirdMap[2] = "2nd" // 8.Измените значение для существующего ключа в изменяемом словаре.
    println(thirdMap)

    for ((key, value) in first) { // 9.Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
        third[key] = value
    }

    for ((key, value) in second){ // 9.Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
        third[key] = value
    }

    println(third)

    stringListMap["String 3"] = listOf(7, 8, 9) // 10. Добавьте несколько элементов в этот словарь.
    stringListMap["String 4"] = listOf(10, 11, 12) // 10. Добавьте несколько элементов в этот словарь.

    println(stringListMap) // 10

    val set = intSetMap[1] // 11. Добавь данные в словарь. Получи значение по ключу (это должно быть множество строк) и добавь в это множество ещё строку. Распечатай полученное множество.
    set?.add("Новая строка")

    println(set)

    for ((pair, value) in pairMap) {
        if (pair.first == 5 || pair.second == 5) {
            println(value)
        }
    } // 12. Через перебор найди значение у которого пара будет содержать цифру 5 в качестве первого или второго значения.
}

