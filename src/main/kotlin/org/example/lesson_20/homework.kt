package org.example.lesson_20

// Напиши функцию getMiddleElement с дженериком, которая будет принимать список и возвращать средний элемент, если он существует, иначе возвращать null.
// Например, у списка из четырёх элементов - среднего элемента нет.


fun <T> getMiddleElement(elements: List<T?>): T?{
    if (elements.isEmpty() || elements.size % 2 == 0) {
        return null
    }
    return elements[elements.size / 2]

}

// Напиши класс ListHolder, который будет хранить список элементов типа T и
// иметь метод для добавления нового элемента и получения всех элементов в виде неизменяемого списка.

class ListHolder<T>(val elements: List<T>) {

    private val mutableElements = elements.toMutableList()

    fun addElement(element: T) {
        mutableElements.add(element)
    }

    fun getElements(): List<T> {
        return mutableElements.toList()
    }

}

//Создай интерфейс Mapper с двумя дженериками, который будет определять методы для преобразования:
//элементов одного типа в элементы другого типа
//списка элементов одного типа в список элементов другого типа

interface Mapper<K, V> {

    fun map(element: K): V

    fun mapList(elements: List<K>): List<V>

}

// Создай класс PhrasesToListOfStrings и имплементируй интефрейс Mapper с типами String и List<String>.
// Метод преобразования должен разбивать входящую строку по символу пробела и возвращать список из полученных слов. Метод преобразования списков с аналогичной механикой.

class PhrasesToListOfStrings : Mapper<String, List<String>> {

    override fun map(element: String): List<String> {
        return element.split(" ")
    }

    override fun mapList(elements: List<String>): List<List<String>> {
        return elements.map { map(it) }
    }
}

// Создай функцию transposition с двумя дженериками, которая принимает словарь с дженериками и возвращает словарь, в котором ключ и значения поменялись местами.

class transposition<K, V>(private val dict: Map<K, V>) {
    fun transpose() : Map<V, K> {
        return dict.entries.associate { (key, value) ->
            value to key}
    }
}

// Напиши интерфейс Validator с дженериком с функцией валидации, которая будет принимать элемент с типом дженерика и возвращать булево значение.

interface Validator<T> {
    fun validation(element: T): Boolean
}

//Создай класс StringValidator и имплементируй интерфейс Validator с типом String?. Реализуй проверку, что строка не является null, не пустая и не состоит из одних пробелов.

class StringValidator: Validator<String?> {
    override fun validation(element: String?): Boolean {
        return !element.isNullOrBlank()
    }

}

// Создай класс OddValidator и имплементируй интерфейс Validator типизированный по Int. Реализуй проверку, что число чётное.

class OddValidator: Validator<Int> {
    override fun validation(element: Int): Boolean {
        return element % 2 == 0
    }
}

//Создай класс ListValidator с дженериком, ограниченным типом Number, имплементируй интерфейс Validator типизированный по типу List с nullable типом дженерика класса
//Реализуй проверку:
//Ни один элемент списка не является null
//Ни один элемент приведённый к типу Double не равен 0.0

class ListValidator<T:Number>: Validator<List<T?>> {

    override fun validation(element: List<T?>): Boolean {
        return element.all {it != null && it.toDouble() != 0.0}
    }
}
