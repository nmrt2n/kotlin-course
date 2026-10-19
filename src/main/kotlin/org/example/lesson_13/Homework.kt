package org.example.lesson_13

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val words = listOf("банан", "яблоко", "груша", "апельсин")
    val nullableWords = listOf("кот", null, "собака", null, "дом")
    val ages = listOf(12, 18, 25, 30, 35, 40)

    // 1. Проверить, что размер коллекции больше 5 элементов
    println(numbers.count() > 5)

    // 2. Проверить, что коллекция пустая
    println(words.none())

    // 3. Проверить, что коллекция не пустая
    println(words.any())

    // 4. Взять элемент по индексу или создать значение,
    // если индекса не существует
    println(words.getOrElse(10) { "Не найдено" })

    // 5. Собрать коллекцию в строку
    println(words.joinToString(", "))

    // 6. Посчитать сумму всех значений
    println(numbers.sum())

    // 7. Посчитать среднее
    println(numbers.average())

    // 8. Взять максимальное число
    println(numbers.maxOrNull())

    // 9. Взять минимальное число
    println(numbers.minOrNull())

    // 10. Взять первое число или null
    println(numbers.firstOrNull())

    // 11. Проверить, что коллекция содержит элемент
    println(words.contains("груша"))

    // 12. Отфильтровать коллекцию по диапазону 18–30
    println(ages.filter { it in 18..30 })

    // 13. Выбрать числа, которые не делятся на 2 и 3 одновременно
    println(numbers.filterNot { it % 2 == 0 && it % 3 == 0 })

    // 14. Очистить текстовую коллекцию от null
    println(nullableWords.filterNotNull())

    // 15. Преобразовать слова в длины
    println(words.map { it.length })

    // 16. Мапа: перевёрнутое слово -> длина слова
    println(words.associate { it.reversed() to it.length })

    // 17. Отсортировать список в алфавитном порядке
    println(words.sorted())

    // 18. Взять первые 3 элемента
    println(words.take(3))

    // 19. Распечатать квадраты элементов
    numbers.forEach { println(it * it) }

    // 20. Группировать слова по первой букве
    println(words.groupBy { it.first().lowercaseChar() })

    // 21. Очистить список от дублей
    println(listOf(1, 2, 2, 3, 3, 4).distinct())

    // 22. Отсортировать список по убыванию
    println(numbers.sortedDescending())

    // 23. Взять последние 3 элемента
    println(words.takeLast(3))
}

//Функция должна проверять условия с помощью when.
// Важно соблюдать порядок условий: если подходит несколько условий,
// сработает первое.

fun characterize(numbers: List<Int>): String {
    return when {
        numbers.isEmpty() -> "Пусто"
        numbers.size < 5 -> "Короткая"
        numbers.first() == 0 -> "Стартовая"
        numbers.sum() > 10000 -> "Массивная"
        numbers.average() == 10.0 -> "Сбалансированная"
        numbers.joinToString("").length == 20 -> "Клейкая"
        numbers.maxOrNull()!! < -10 -> "Отрицательная"
        numbers.minOrNull()!! > 1000 -> "Положительная"
        numbers.containsAll(listOf(3, 14)) -> "Пи***тая"
        else -> "Уникальная"
    }
}

fun main1() {
    val examples = listOf(
        emptyList(),
        listOf(1, 2, 3),
        listOf(0, 5, 6, 7, 8),
        listOf(3000, 3000, 3000, 3000),
        listOf(10, 10, 10, 10, 10),
        listOf(12345, 67890, 12345, 67890),
        listOf(-20, -15, -12, -11, -30),
        listOf(1001, 2000, 3000, 4000, 5000),
        listOf(3, 14, 1, 2, 5),
        listOf(1, 2, 3, 4, 5)
    )

    examples.forEach {
        println("$it -> ${characterize(it)}")
    }
}

//Нужно последовательно отфильтровать оценки от 60,
// отсортировать по возрастанию и взять первые три.

fun analyzeGrades(grades: List<Int>): List<Int> {
    return grades
        .filter { it >= 60 }
        .sorted()
        .take(3)
}

fun main2() {
    val grades = listOf(
        85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12
    )

    println(analyzeGrades(grades))
}

// groupBy сгруппирует слова по первой букве
// после приведения всех строк к нижнему регистру.
fun createCatalog(list: List<String>): Map<Char, List<String>> {
    return list
        .map { it.lowercase() }
        .groupBy { it.first() }
}

fun main3() {
    val list = listOf(
        "Стол", "табурет", "ваза", "Кружка", "Зеркало",
        "ковер", "Шкаф", "часы", "Люстра", "подушка",
        "Картина", "столик", "Вазон", "шторы", "Пуф",
        "книга", "Фоторамка", "светильник", "Коврик",
        "вешалка", "Подставка", "телевизор", "Комод",
        "полка", "Абажур", "диван", "Кресло", "занавеска",
        "Бра", "пепельница", "Глобус", "статуэтка",
        "Поднос", "фигурка", "Ключница", "плед", "Тумба",
        "игрушка", "Настенные часы", "подсвечник",
        "Журнальный столик", "сувенир", "Корзина для белья",
        "посуда", "Настольная лампа", "торшер", "Этажерка"
    )

    val catalog = createCatalog(list)
    catalog.forEach { (letter, items) ->
        println("$letter: $items")
    }
}

//Сначала преобразуем каждое слово в его длину,
// затем вычислим среднее и отформатируем результат
// с двумя знаками после запятой.

import java.util.Locale

fun averageWordLength(words: List<String>): String {
    val average = words
        .map { it.length }
        .average()

    return String.format(Locale.US, "%.2f", average)
}

fun main4() {
    val list = listOf(
        "Стол", "табурет", "ваза", "Кружка", "Зеркало",
        "ковер", "Шкаф", "часы", "Люстра", "подушка",
        "Картина", "столик", "Вазон", "шторы", "Пуф",
        "книга", "Фоторамка", "светильник", "Коврик",
        "вешалка", "Подставка", "телевизор", "Комод",
        "полка", "Абажур", "диван", "Кресло", "занавеска",
        "Бра", "пепельница", "Глобус", "статуэтка",
        "Поднос", "фигурка", "Ключница", "плед", "Тумба",
        "игрушка", "Настенные часы", "подсвечник",
        "Журнальный столик", "сувенир", "Корзина для белья",
        "посуда", "Настольная лампа", "торшер", "Этажерка"
    )

    println(averageWordLength(list))
}

// Нужно оставить уникальные числа,
// отсортировать их по убыванию и сгруппировать по чётности.

fun categorizeNumbers(numbers: List<Int>): Map<String, List<Int>> {
    return numbers
        .distinct()
        .sortedDescending()
        .groupBy {
            if (it % 2 == 0) "четные" else "нечетные"
        }
}

fun main5() {
    val numbers = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)

    println(categorizeNumbers(numbers))
}