package org.example.lesson_21
import kotlin.math.absoluteValue

//1. Определите функцию-расширение для массива чисел, которая не принимает аргументов и возвращает пару из чисел - первое и последнее. Если массив был пуст то вернуть пару из null значений.

fun Array<Int>.firstAndLast(): Pair<Int?, Int?> {
    return if (isEmpty()) {
        Pair(null, null)
    }
    else {
        Pair(first(), last())
    }
}

//2. Создайте функцию-расширение для изменяемого списка элементов:
//с дженериком T ограниченным интерфейсом Comparable<T>
//которая принимает булево значение
//возвращает этот же список только в виде неизменяемого
//сам изменяемый список при этом должен стать отсортированным по возрастанию, если в функцию передано true и по убыванию, если false (используем функции sort() и sortDescending()

fun <T: Comparable<T>> MutableList<T>.sortAndReturn(element: Boolean): List<T> {
    if (element) {
        this.sort()
    }
    else {
        this.sortDescending()
    }

    return this.toList()
}

//3. Создайте функцию-расширение для nullable словаря с дженериком:
//Ключ является дженериком
//Значение является списком из дженериков
//Принимает целое число
//Возвращает nullable словарь из ключей изначального словаря приведённых к строке через toString()
//Значений из nullable дженерика, взятых из изначального ключа-списка по индексу из аргумента, если такого индекса нет - значением будет null

fun <K, V> Map<K, List<V>>?.getElementByIndex(index: Int): Map<String, V?>? {
    return this?.mapKeys { it.key.toString() }
        ?.mapValues { it.value.getOrNull(index) }
}

//4. Реализуйте метод расширения within для класса Number, который проверяет, что текущее число отклоняется от эталонного не более допустимого значения. Метод принимает два параметра: other — число для сравнения и deviation — максимально допустимое отклонение. Метод должен возвращать true, если разница между текущим числом и числом для сравнения не превышает заданное отклонение. Протестируйте функцию на разных типах чисел. Для получения отклонения, у разницы чисел нужно вызвать свойство absoluteValue.

fun Number.within(other: Number, deviation: Number): Boolean {
    return (this.toDouble() - other.toDouble()).absoluteValue <= deviation.toDouble()
}



//5. Реализуйте для класса String два метода расширения: encrypt и decrypt. Метод encrypt должен сдвигать каждый символ исходной строки на заданное число позиций вперед по таблице Unicode, а метод decrypt — на то же число позиций назад. Оба метода принимают один параметр base типа Int, который определяет величину сдвига. Протестируйте вашу реализацию, убедившись, что после шифрования и последующей расшифровки строка возвращается к исходному состоянию.
//Сдвиг по таблице Unicode реализуется простым прибавлением или вычитанием размера сдвига к char символу.

fun String.crypt(base: Int): String {
    var result = ""

    for (symbol in this) {
        result += (symbol.code + base).toChar()
    }

    return result
}

fun String.decrypt(base: Int): String {
    var result = ""

    for (symbol in this) {
        result += (symbol.code - base).toChar()
    }

    return result
}


//6. Напиши метод расширения строки, который будет принимать список имён пользователей и выводить в консоли исходную строку побуквенно в верхнем регистре в столбик: имя автора и букву под ним.

fun String.printFirstLetter(users: List<String>) {
    for (i in this.indices) {
        println(this[i].uppercase())
        println(getOrNull(i) ?: "Нет автора")
        println()
    }
}
